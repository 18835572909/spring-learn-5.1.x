package com.rhb.spring.parsing.beans.base;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * @author renhuibo
 * @date 2022/7/21 17:07
 */
public abstract class AttributeAccessorSupport implements AttributeAccessor, Serializable {

  /**
   * 元数据容器
   */
  private final Map<String, Object> attributes = new LinkedHashMap<>();

  /**
   * 设置元数据（注意： 如果value是空，将移除元数据）
   */
  @Override
  public void setAttribute(String name, @Nullable Object value) {
    Assert.notNull(name, "Name must not be null");
    if (value != null) {
      this.attributes.put(name, value);
    }else {
      removeAttribute(name);
    }
  }

  @Override
  @Nullable
  public Object getAttribute(String name) {
    Assert.notNull(name, "Name must not be null");
    return this.attributes.get(name);
  }

  @Override
  @Nullable
  public Object removeAttribute(String name) {
    Assert.notNull(name, "Name must not be null");
    return this.attributes.remove(name);
  }

  @Override
  public boolean hasAttribute(String name) {
    Assert.notNull(name, "Name must not be null");
    return this.attributes.containsKey(name);
  }

  @Override
  public String[] attributeNames() {
    return StringUtils.toStringArray(this.attributes.keySet());
  }


  /**
   * Copy the attributes from the supplied AttributeAccessor to this accessor.
   * @param source the AttributeAccessor to copy from
   */
  protected void copyAttributesFrom(AttributeAccessor source) {
    Assert.notNull(source, "Source must not be null");
    String[] attributeNames = source.attributeNames();
    for (String attributeName : attributeNames) {
      setAttribute(attributeName, source.getAttribute(attributeName));
    }
  }


  @Override
  public boolean equals(Object other) {
    return (this == other || (other instanceof AttributeAccessorSupport &&
        this.attributes.equals(((AttributeAccessorSupport) other).attributes)));
  }

  @Override
  public int hashCode() {
    return this.attributes.hashCode();
  }
}
