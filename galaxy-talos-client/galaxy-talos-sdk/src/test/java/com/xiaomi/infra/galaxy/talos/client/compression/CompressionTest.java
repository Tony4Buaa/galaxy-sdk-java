/**
 * Copyright 2015, Xiaomi.
 * All rights reserved.
 * Author: xiajun@xiaomi.com
 */

package com.xiaomi.infra.galaxy.talos.client.compression;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xiaomi.infra.galaxy.talos.thrift.Message;
import com.xiaomi.infra.galaxy.talos.thrift.MessageAndOffset;
import com.xiaomi.infra.galaxy.talos.thrift.MessageBlock;
import com.xiaomi.infra.galaxy.talos.thrift.MessageCompressionType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CompressionTest {
  private static final Logger LOG = LoggerFactory.getLogger(CompressionTest.class);

  private List<Message> messageList;
  private int rowMessageSize;

  @Before
  public void setUp() throws Exception {
    messageList = new ArrayList<Message>(100);
    rowMessageSize = 0;
    for (int i = 1; i <= 100; ++i) {
      Message message = new Message();

      // set sequence number;
      if (i % 2 == 0) {
        message.setSequenceNumber(String.valueOf(i));
        rowMessageSize += 4 + String.valueOf(i).getBytes(Charset.forName("UTF-8")).length;
      } else {
        rowMessageSize += 4;
      }

      // set message data;
      byte[] data = new byte[i];
      for (int index = 0; index < i; ++index) {
        data[index] = (byte)i;
      }
      message.setMessage(data);
      rowMessageSize += 4 + data.length;

      messageList.add(message);
    }
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testNoCompression() throws Exception {
    LOG.info("message Bytes: " + rowMessageSize);
    long unHandledMessageNumber = 117;
    MessageBlock messageBlock = Compression.compress(messageList, MessageCompressionType.NONE);
    assertEquals(MessageCompressionType.NONE, messageBlock.getCompressionType());
    assertEquals(messageList.size(), messageBlock.getMessageNumber());
    long startOffset = 1234;
    messageBlock.setStartMessageOffset(startOffset);
    LOG.info("CompressionType: None, message BlockSize: " + messageBlock.getMessageBlock().length);

    List<MessageAndOffset> verifyMessageList = Compression.decompress(messageBlock, unHandledMessageNumber);
    assertEquals(messageList.size(), verifyMessageList.size());
    for (int index = 0; index < messageList.size(); ++index) {
      assertEquals(messageList.get(index), verifyMessageList.get(index).getMessage());
      assertEquals(startOffset + index, verifyMessageList.get(index).getMessageOffset());
      assertTrue(verifyMessageList.get(index).getUnHandledMessageNumber() ==
          (unHandledMessageNumber + messageList.size() - 1 - index));
    }
  }

  @Test
  public void testSnappy() throws Exception {
    LOG.info("message Bytes: " + rowMessageSize);
    MessageBlock messageBlock = Compression.compress(messageList, MessageCompressionType.SNAPPY);
    assertEquals(MessageCompressionType.SNAPPY, messageBlock.getCompressionType());
    assertEquals(messageList.size(), messageBlock.getMessageNumber());
    long startOffset = 1234;
    long unHandledMessageNumber = 117;
    messageBlock.setStartMessageOffset(startOffset);
    LOG.info("CompressionType: Snappy, message BlockSize: " + messageBlock.getMessageBlock().length);

    List<MessageAndOffset> verifyMessageList = Compression.decompress(messageBlock, unHandledMessageNumber);
    assertEquals(messageList.size(), verifyMessageList.size());
    for (int index = 0; index < messageList.size(); ++index) {
      assertEquals(messageList.get(index), verifyMessageList.get(index).getMessage());
      assertEquals(startOffset + index, verifyMessageList.get(index).getMessageOffset());
      assertTrue(verifyMessageList.get(index).getUnHandledMessageNumber() ==
          (unHandledMessageNumber + messageList.size() - 1 - index));
    }
  }

  @Test
  public void testGzip() throws Exception {
    LOG.info("message Bytes: " + rowMessageSize);
    MessageBlock messageBlock = Compression.compress(messageList, MessageCompressionType.GZIP);
    assertEquals(MessageCompressionType.GZIP, messageBlock.getCompressionType());
    assertEquals(messageList.size(), messageBlock.getMessageNumber());
    long startOffset = 1234;
    long unHandledMessageNumber = 117;
    messageBlock.setStartMessageOffset(startOffset);
    LOG.info("CompressionType: Gzip, message BlockSize: " + messageBlock.getMessageBlock().length);

    List<MessageAndOffset> verifyMessageList = Compression.decompress(messageBlock, unHandledMessageNumber);
    assertEquals(messageList.size(), verifyMessageList.size());
    for (int index = 0; index < messageList.size(); ++index) {
      assertEquals(messageList.get(index), verifyMessageList.get(index).getMessage());
      assertEquals(startOffset + index, verifyMessageList.get(index).getMessageOffset());
      assertTrue(verifyMessageList.get(index).getUnHandledMessageNumber() ==
          (unHandledMessageNumber + messageList.size() - 1 - index));
    }
  }

  @Test
  public void testList() throws Exception {
    MessageBlock messageBlock1 = Compression.compress(messageList, MessageCompressionType.NONE);
    MessageBlock messageBlock2 = Compression.compress(messageList, MessageCompressionType.SNAPPY);
    MessageBlock messageBlock3 = Compression.compress(messageList, MessageCompressionType.GZIP);
    long startOffset = 1234;
    messageBlock1.setStartMessageOffset(startOffset);
    messageBlock2.setStartMessageOffset(messageBlock1.getStartMessageOffset() + messageBlock1.getMessageNumber());
    messageBlock3.setStartMessageOffset(messageBlock2.getStartMessageOffset() + messageBlock2.getMessageNumber() );

    List<MessageBlock> messageBlockList = new ArrayList<MessageBlock>(3);
    messageBlockList.add(messageBlock1);
    messageBlockList.add(messageBlock2);
    messageBlockList.add(messageBlock3);
    long unHandledMessageNumber = 117;

    List<MessageAndOffset> messageAndOffsetList = Compression.decompress(messageBlockList, unHandledMessageNumber);
    assertEquals(messageList.size() * 3, messageAndOffsetList.size());
    for (int index = 0; index < messageAndOffsetList.size(); ++index) {
      assertEquals(messageList.get(index % messageList.size()), messageAndOffsetList.get(index).getMessage());
      assertEquals(startOffset + index, messageAndOffsetList.get(index).getMessageOffset());
      assertTrue(messageAndOffsetList.get(index).getUnHandledMessageNumber() ==
          (unHandledMessageNumber + messageAndOffsetList.size() - 1 - index));
    }
  }
}