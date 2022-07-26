package com.rhb.spring.parsing.beans.base;

import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.springframework.lang.Nullable;

/**
 * {desc}
 *
 * @author renhuibo
 * @date 2022/7/21 19:47
 */
public class MethodOverrides {

  private final Set<MethodOverride> overrides = new CopyOnWriteArraySet<>();


  /**
   * Create new MethodOverrides.
   */
  public MethodOverrides() {
  }

  /**
   * Deep copy constructor.
   */
  public MethodOverrides(MethodOverrides other) {
    addOverrides(other);
  }


  /**
   * Copy all given method overrides into this object.
   */
  public void addOverrides(@Nullable MethodOverrides other) {
    if (other != null) {
      this.overrides.addAll(other.overrides);
    }
  }

  /**
   * Add the given method override.
   */
  public void addOverride(MethodOverride override) {
    this.overrides.add(override);
  }

  /**
   * Return all method overrides contained by this object.
   * @return a Set of MethodOverride objects
   * @see MethodOverride
   */
  public Set<MethodOverride> getOverrides() {
    return this.overrides;
  }

  /**
   * Return whether the set of method overrides is empty.
   */
  public boolean isEmpty() {
    return this.overrides.isEmpty();
  }

  /**
   * Return the override for the given method, if any.
   * @param method method to check for overrides for
   * @return the method override, or {@code null} if none
   */
  @Nullable
  public MethodOverride getOverride(Method method) {
    MethodOverride match = null;
    for (MethodOverride candidate : this.overrides) {
      if (candidate.matches(method)) {
        match = candidate;
      }
    }
    return match;
  }


  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof MethodOverrides)) {
      return false;
    }
    MethodOverrides that = (MethodOverrides) other;
    return this.overrides.equals(that.overrides);
  }

  @Override
  public int hashCode() {
    return this.overrides.hashCode();
  }
  
}
