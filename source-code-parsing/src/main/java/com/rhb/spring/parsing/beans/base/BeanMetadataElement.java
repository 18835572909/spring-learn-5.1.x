package com.rhb.spring.parsing.beans.base;

import org.springframework.lang.Nullable;

/**
 * {desc}
 *
 * @author renhuibo
 * @date 2022/7/21 16:26
 */
public interface BeanMetadataElement {

  /**
   * 方法返回 Bean 的来源
   */
  @Nullable
  Object getSource();
}
