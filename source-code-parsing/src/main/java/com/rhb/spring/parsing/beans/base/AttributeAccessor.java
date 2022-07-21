package com.rhb.spring.parsing.beans.base;

import org.springframework.lang.Nullable;

/**
 * 定义元数据的访问
 *
 * @author renhuibo
 * @date 2022/7/21 16:25
 */
public interface AttributeAccessor {

  void setAttribute(String var1, @Nullable Object var2);

  Object getAttribute(String var1);

  Object removeAttribute(String var1);

  boolean hasAttribute(String var1);

  String[] attributeNames();
}
