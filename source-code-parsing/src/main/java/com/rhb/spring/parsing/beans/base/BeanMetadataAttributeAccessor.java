package com.rhb.spring.parsing.beans.base;

import org.springframework.lang.Nullable;

/**
 * 设计数据存放结构： LinkedHashMap<name,(name,value,resource)>
 *
 * @author renhuibo
 * @date 2022/7/21 18:21
 */
public class BeanMetadataAttributeAccessor extends AttributeAccessorSupport implements BeanMetadataElement{

  private Object source;

  public void setSource(@Nullable Object source) {
    this.source = source;
  }

  @Override
  @Nullable
  public Object getSource() {
    return this.source;
  }

  /**
   * BeanMetadataAttribute是添加name,value的BeanMetadataEmlement
   *
   * 这里类似： 享元设计模式，将List<BeanMetadataAttribute> => Map<BeanMetadataAttribute.getName(),BeanMetadataAttribute>
   *
   * 还要注意的是： AttributeAccessorSupport的attr容器是LinkedHashMap
   *
   * 这里就有点小饶了： 其实这里最终的存放是：LinkedHashMap<name,(name,value,resource)>
   */
  public void addMetadataAttribute(BeanMetadataAttribute attribute) {
    super.setAttribute(attribute.getName(), attribute);
  }

  @Nullable
  public BeanMetadataAttribute getMetadataAttribute(String name) {
    return (BeanMetadataAttribute) super.getAttribute(name);
  }
}
