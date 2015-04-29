/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.xiaomi.infra.galaxy.sds.thrift;


import java.util.Map;
import java.util.HashMap;
import libthrift091.TEnum;

/**
 * 表状态
 */
public enum TableState implements libthrift091.TEnum {
  /**
   * 正在创建，不可操作
   */
  CREATING(1),
  /**
   * 正在开启，不可操作
   */
  ENABLING(2),
  /**
   * 开启状态，可读写
   */
  ENABLED(3),
  /**
   * 正在关闭，不可操作
   */
  DISABLING(4),
  /**
   * 关闭状态，不可读写
   */
  DISABLED(5),
  /**
   * 正在删除，不可见
   */
  DROPPING(6),
  /**
   * 已删除，不可见
   */
  DROPPED(7),
  /**
   * 正在延迟删除，不可操作
   */
  LAZY_DROPPING(8),
  /**
   * 延迟删除, 可见
   */
  LAZY_DROP(9),
  /**
   * 正在恢复, 不可操作
   */
  RESTORING(10);

  private final int value;

  private TableState(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static TableState findByValue(int value) { 
    switch (value) {
      case 1:
        return CREATING;
      case 2:
        return ENABLING;
      case 3:
        return ENABLED;
      case 4:
        return DISABLING;
      case 5:
        return DISABLED;
      case 6:
        return DROPPING;
      case 7:
        return DROPPED;
      case 8:
        return LAZY_DROPPING;
      case 9:
        return LAZY_DROP;
      case 10:
        return RESTORING;
      default:
        return null;
    }
  }
}
