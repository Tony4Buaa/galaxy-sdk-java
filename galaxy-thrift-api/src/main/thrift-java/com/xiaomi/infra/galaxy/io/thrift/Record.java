/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.xiaomi.infra.galaxy.io.thrift;

import libthrift091.scheme.IScheme;
import libthrift091.scheme.SchemeFactory;
import libthrift091.scheme.StandardScheme;

import libthrift091.scheme.TupleScheme;
import libthrift091.protocol.TTupleProtocol;
import libthrift091.protocol.TProtocolException;
import libthrift091.EncodingUtils;
import libthrift091.TException;
import libthrift091.async.AsyncMethodCallback;
import libthrift091.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
/**
 * 记录
 */
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2015-5-22")
public class Record implements libthrift091.TBase<Record, Record._Fields>, java.io.Serializable, Cloneable, Comparable<Record> {
  private static final libthrift091.protocol.TStruct STRUCT_DESC = new libthrift091.protocol.TStruct("Record");

  private static final libthrift091.protocol.TField DATA_FIELD_DESC = new libthrift091.protocol.TField("data", libthrift091.protocol.TType.STRING, (short)1);
  private static final libthrift091.protocol.TField CHECKSUM_FIELD_DESC = new libthrift091.protocol.TField("checksum", libthrift091.protocol.TType.I32, (short)2);
  private static final libthrift091.protocol.TField EOF_FIELD_DESC = new libthrift091.protocol.TField("eof", libthrift091.protocol.TType.BOOL, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new RecordStandardSchemeFactory());
    schemes.put(TupleScheme.class, new RecordTupleSchemeFactory());
  }

  /**
   * 记录数据部分，仅用于非EOF记录
   */
  public ByteBuffer data; // optional
  /**
   * 数据部分的校验值，可选
   */
  public int checksum; // optional
  /**
   * EOF记录，用于标记文件结束
   */
  public boolean eof; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements libthrift091.TFieldIdEnum {
    /**
     * 记录数据部分，仅用于非EOF记录
     */
    DATA((short)1, "data"),
    /**
     * 数据部分的校验值，可选
     */
    CHECKSUM((short)2, "checksum"),
    /**
     * EOF记录，用于标记文件结束
     */
    EOF((short)3, "eof");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // DATA
          return DATA;
        case 2: // CHECKSUM
          return CHECKSUM;
        case 3: // EOF
          return EOF;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __CHECKSUM_ISSET_ID = 0;
  private static final int __EOF_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.DATA,_Fields.CHECKSUM,_Fields.EOF};
  public static final Map<_Fields, libthrift091.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, libthrift091.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, libthrift091.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.DATA, new libthrift091.meta_data.FieldMetaData("data", libthrift091.TFieldRequirementType.OPTIONAL, 
        new libthrift091.meta_data.FieldValueMetaData(libthrift091.protocol.TType.STRING        , true)));
    tmpMap.put(_Fields.CHECKSUM, new libthrift091.meta_data.FieldMetaData("checksum", libthrift091.TFieldRequirementType.OPTIONAL, 
        new libthrift091.meta_data.FieldValueMetaData(libthrift091.protocol.TType.I32)));
    tmpMap.put(_Fields.EOF, new libthrift091.meta_data.FieldMetaData("eof", libthrift091.TFieldRequirementType.OPTIONAL, 
        new libthrift091.meta_data.FieldValueMetaData(libthrift091.protocol.TType.BOOL)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    libthrift091.meta_data.FieldMetaData.addStructMetaDataMap(Record.class, metaDataMap);
  }

  public Record() {
    this.eof = false;

  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Record(Record other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetData()) {
      this.data = libthrift091.TBaseHelper.copyBinary(other.data);
    }
    this.checksum = other.checksum;
    this.eof = other.eof;
  }

  public Record deepCopy() {
    return new Record(this);
  }

  @Override
  public void clear() {
    this.data = null;
    setChecksumIsSet(false);
    this.checksum = 0;
    this.eof = false;

  }

  /**
   * 记录数据部分，仅用于非EOF记录
   */
  public byte[] getData() {
    setData(libthrift091.TBaseHelper.rightSize(data));
    return data == null ? null : data.array();
  }

  public ByteBuffer bufferForData() {
    return libthrift091.TBaseHelper.copyBinary(data);
  }

  /**
   * 记录数据部分，仅用于非EOF记录
   */
  public Record setData(byte[] data) {
    this.data = data == null ? (ByteBuffer)null : ByteBuffer.wrap(Arrays.copyOf(data, data.length));
    return this;
  }

  public Record setData(ByteBuffer data) {
    this.data = libthrift091.TBaseHelper.copyBinary(data);
    return this;
  }

  public void unsetData() {
    this.data = null;
  }

  /** Returns true if field data is set (has been assigned a value) and false otherwise */
  public boolean isSetData() {
    return this.data != null;
  }

  public void setDataIsSet(boolean value) {
    if (!value) {
      this.data = null;
    }
  }

  /**
   * 数据部分的校验值，可选
   */
  public int getChecksum() {
    return this.checksum;
  }

  /**
   * 数据部分的校验值，可选
   */
  public Record setChecksum(int checksum) {
    this.checksum = checksum;
    setChecksumIsSet(true);
    return this;
  }

  public void unsetChecksum() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __CHECKSUM_ISSET_ID);
  }

  /** Returns true if field checksum is set (has been assigned a value) and false otherwise */
  public boolean isSetChecksum() {
    return EncodingUtils.testBit(__isset_bitfield, __CHECKSUM_ISSET_ID);
  }

  public void setChecksumIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __CHECKSUM_ISSET_ID, value);
  }

  /**
   * EOF记录，用于标记文件结束
   */
  public boolean isEof() {
    return this.eof;
  }

  /**
   * EOF记录，用于标记文件结束
   */
  public Record setEof(boolean eof) {
    this.eof = eof;
    setEofIsSet(true);
    return this;
  }

  public void unsetEof() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __EOF_ISSET_ID);
  }

  /** Returns true if field eof is set (has been assigned a value) and false otherwise */
  public boolean isSetEof() {
    return EncodingUtils.testBit(__isset_bitfield, __EOF_ISSET_ID);
  }

  public void setEofIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __EOF_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case DATA:
      if (value == null) {
        unsetData();
      } else {
        setData((ByteBuffer)value);
      }
      break;

    case CHECKSUM:
      if (value == null) {
        unsetChecksum();
      } else {
        setChecksum((Integer)value);
      }
      break;

    case EOF:
      if (value == null) {
        unsetEof();
      } else {
        setEof((Boolean)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case DATA:
      return getData();

    case CHECKSUM:
      return Integer.valueOf(getChecksum());

    case EOF:
      return Boolean.valueOf(isEof());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case DATA:
      return isSetData();
    case CHECKSUM:
      return isSetChecksum();
    case EOF:
      return isSetEof();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Record)
      return this.equals((Record)that);
    return false;
  }

  public boolean equals(Record that) {
    if (that == null)
      return false;

    boolean this_present_data = true && this.isSetData();
    boolean that_present_data = true && that.isSetData();
    if (this_present_data || that_present_data) {
      if (!(this_present_data && that_present_data))
        return false;
      if (!this.data.equals(that.data))
        return false;
    }

    boolean this_present_checksum = true && this.isSetChecksum();
    boolean that_present_checksum = true && that.isSetChecksum();
    if (this_present_checksum || that_present_checksum) {
      if (!(this_present_checksum && that_present_checksum))
        return false;
      if (this.checksum != that.checksum)
        return false;
    }

    boolean this_present_eof = true && this.isSetEof();
    boolean that_present_eof = true && that.isSetEof();
    if (this_present_eof || that_present_eof) {
      if (!(this_present_eof && that_present_eof))
        return false;
      if (this.eof != that.eof)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_data = true && (isSetData());
    list.add(present_data);
    if (present_data)
      list.add(data);

    boolean present_checksum = true && (isSetChecksum());
    list.add(present_checksum);
    if (present_checksum)
      list.add(checksum);

    boolean present_eof = true && (isSetEof());
    list.add(present_eof);
    if (present_eof)
      list.add(eof);

    return list.hashCode();
  }

  @Override
  public int compareTo(Record other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetData()).compareTo(other.isSetData());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetData()) {
      lastComparison = libthrift091.TBaseHelper.compareTo(this.data, other.data);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetChecksum()).compareTo(other.isSetChecksum());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetChecksum()) {
      lastComparison = libthrift091.TBaseHelper.compareTo(this.checksum, other.checksum);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetEof()).compareTo(other.isSetEof());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEof()) {
      lastComparison = libthrift091.TBaseHelper.compareTo(this.eof, other.eof);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(libthrift091.protocol.TProtocol iprot) throws libthrift091.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(libthrift091.protocol.TProtocol oprot) throws libthrift091.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Record(");
    boolean first = true;

    if (isSetData()) {
      sb.append("data:");
      if (this.data == null) {
        sb.append("null");
      } else {
        libthrift091.TBaseHelper.toString(this.data, sb);
      }
      first = false;
    }
    if (isSetChecksum()) {
      if (!first) sb.append(", ");
      sb.append("checksum:");
      sb.append(this.checksum);
      first = false;
    }
    if (isSetEof()) {
      if (!first) sb.append(", ");
      sb.append("eof:");
      sb.append(this.eof);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws libthrift091.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new libthrift091.protocol.TCompactProtocol(new libthrift091.transport.TIOStreamTransport(out)));
    } catch (libthrift091.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new libthrift091.protocol.TCompactProtocol(new libthrift091.transport.TIOStreamTransport(in)));
    } catch (libthrift091.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class RecordStandardSchemeFactory implements SchemeFactory {
    public RecordStandardScheme getScheme() {
      return new RecordStandardScheme();
    }
  }

  private static class RecordStandardScheme extends StandardScheme<Record> {

    public void read(libthrift091.protocol.TProtocol iprot, Record struct) throws libthrift091.TException {
      libthrift091.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == libthrift091.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // DATA
            if (schemeField.type == libthrift091.protocol.TType.STRING) {
              struct.data = iprot.readBinary();
              struct.setDataIsSet(true);
            } else { 
              libthrift091.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // CHECKSUM
            if (schemeField.type == libthrift091.protocol.TType.I32) {
              struct.checksum = iprot.readI32();
              struct.setChecksumIsSet(true);
            } else { 
              libthrift091.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // EOF
            if (schemeField.type == libthrift091.protocol.TType.BOOL) {
              struct.eof = iprot.readBool();
              struct.setEofIsSet(true);
            } else { 
              libthrift091.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            libthrift091.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(libthrift091.protocol.TProtocol oprot, Record struct) throws libthrift091.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.data != null) {
        if (struct.isSetData()) {
          oprot.writeFieldBegin(DATA_FIELD_DESC);
          oprot.writeBinary(struct.data);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetChecksum()) {
        oprot.writeFieldBegin(CHECKSUM_FIELD_DESC);
        oprot.writeI32(struct.checksum);
        oprot.writeFieldEnd();
      }
      if (struct.isSetEof()) {
        oprot.writeFieldBegin(EOF_FIELD_DESC);
        oprot.writeBool(struct.eof);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class RecordTupleSchemeFactory implements SchemeFactory {
    public RecordTupleScheme getScheme() {
      return new RecordTupleScheme();
    }
  }

  private static class RecordTupleScheme extends TupleScheme<Record> {

    @Override
    public void write(libthrift091.protocol.TProtocol prot, Record struct) throws libthrift091.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetData()) {
        optionals.set(0);
      }
      if (struct.isSetChecksum()) {
        optionals.set(1);
      }
      if (struct.isSetEof()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetData()) {
        oprot.writeBinary(struct.data);
      }
      if (struct.isSetChecksum()) {
        oprot.writeI32(struct.checksum);
      }
      if (struct.isSetEof()) {
        oprot.writeBool(struct.eof);
      }
    }

    @Override
    public void read(libthrift091.protocol.TProtocol prot, Record struct) throws libthrift091.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.data = iprot.readBinary();
        struct.setDataIsSet(true);
      }
      if (incoming.get(1)) {
        struct.checksum = iprot.readI32();
        struct.setChecksumIsSet(true);
      }
      if (incoming.get(2)) {
        struct.eof = iprot.readBool();
        struct.setEofIsSet(true);
      }
    }
  }

}

