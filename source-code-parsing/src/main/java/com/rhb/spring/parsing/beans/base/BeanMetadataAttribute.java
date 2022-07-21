package com.rhb.spring.parsing.beans.base;

import lombok.Getter;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

/**
 * BeanMetadataElement的实现类，在原有基础上，添加name、value属性
 *
 * @author renhuibo
 * @date 2022/7/21 18:23
 */
@Getter
public class BeanMetadataAttribute implements BeanMetadataElement {

  private final String name;

  @Nullable
  private final Object value;

  @Nullable
  private Object source;

  public BeanMetadataAttribute(String name, @Nullable Object value) {
    Assert.notNull(name, "Name must not be null");
    this.name = name;
    this.value = value;
  }

  /**
   *  nullSafeHashCode(): 空值安全，如果是空，就返回0 【可以参考】
   */
  @Override
  public int hashCode() {
    return this.name.hashCode() * 29 + ObjectUtils.nullSafeHashCode(this.value);
  }

  @Override
  public String toString() {
    return "metadata attribute '" + this.name + "'";
  }
}
