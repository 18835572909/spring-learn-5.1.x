package com.rhb.spring.parsing.beans.definition;

import com.rhb.spring.parsing.beans.base.AttributeAccessor;
import com.rhb.spring.parsing.beans.base.BeanMetadataElement;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.lang.Nullable;

/**
 * Spring中Bean的定义类，包含其他属性
 *
 * AttributeAccessor：提供设置元数据信息的功能
 * BeanMetadataElement：主要提供获取Bean的来源的功能
 */
public interface BeanDefinition extends AttributeAccessor, BeanMetadataElement {

	/**
	 * 常量定义： scope和role
	 */
	String SCOPE_SINGLETON = ConfigurableBeanFactory.SCOPE_SINGLETON;

	String SCOPE_PROTOTYPE = ConfigurableBeanFactory.SCOPE_PROTOTYPE;

	int ROLE_APPLICATION = 0;

	int ROLE_SUPPORT = 1;

	int ROLE_INFRASTRUCTURE = 2;

	/****************************************可更改属性**********************************************/
	/**
	 * 设置父类名
	 */
	void setParentName(@Nullable String parentName);
	String getParentName();

	/**
	 * 配置 Bean 的 Class 全路径
	 */
	void setBeanClassName(@Nullable String beanClassName);
	String getBeanClassName();

	/**
	 * 是否单例
	 * @param scope
	 */
	void setScope(@Nullable String scope);
	String getScope();

	/**
	 *  配置/获取 Bean 是否懒加载
	 *  返回该bean是否应该被惰性初始化，即不应该在启动时立即初始化。仅适用于单例bean
	 */
	void setLazyInit(boolean lazyInit);
	boolean isLazyInit();

	/**
	 * 设置初始化此bean所依赖的bean的名称。bean工厂将保证首先初始化这些bean.
	 */
	void setDependsOn(@Nullable String... dependsOn);
	String[] getDependsOn();

	/**
	 * 配置/获取 Bean 是否是自动装配
	 */
	void setAutowireCandidate(boolean autowireCandidate);
	boolean isAutowireCandidate();

	/**
	 * 是否优先加载
	 */
	void setPrimary(boolean primary);
	boolean isPrimary();

	/**
	 * 配置/获取 FactoryBean 的名字
	 */
	void setFactoryBeanName(@Nullable String factoryBeanName);
	String getFactoryBeanName();

	/**
	 * 配置/获取 FactoryBean 的名字
	 */
	void setFactoryMethodName(@Nullable String factoryMethodName);
	String getFactoryMethodName();

	/**
	 * 获取当前Bean的构造参数值
	 */
	ConstructorArgumentValues getConstructorArgumentValues();
	default boolean hasConstructorArgumentValues() {
		return !getConstructorArgumentValues().isEmpty();
	}

	/**
	 * 获取bean的所有属性值
	 * 返回的实例可以在bean工厂后处理期间修改
	 */
	MutablePropertyValues getPropertyValues();
	default boolean hasPropertyValues() {
		return !getPropertyValues().isEmpty();
	}

	/**
	 * 设置初始化Bean的方法
	 */
	void setInitMethodName(@Nullable String initMethodName);
	String getInitMethodName();

	/**
	 * 设置Bean摧毁的方法
	 */
	void setDestroyMethodName(@Nullable String destroyMethodName);
	String getDestroyMethodName();

	/**
	 * 设置角色提示。角色提示为框架和工具提供了特定的角色和重要性的指示。
	 * @see #ROLE_APPLICATION   ： 用户自定义的
	 * @see #ROLE_SUPPORT       ： 其他复杂配置的支撑部分
	 * @see #ROLE_INFRASTRUCTURE： spring内部使用
	 */
	void setRole(int role);
	int getRole();

	/**
	 * Bean的描述
	 */
	void setDescription(@Nullable String description);
	String getDescription();

	/***********************************************************************************************/


	/***********************************************只读属性*****************************************/
	/**
	 * 是否单例
	 */
	boolean isSingleton();

	/**
	 * 是否原型（多例）
	 */
	boolean isPrototype();

	/**
	 * 是否抽象
	 */
	boolean isAbstract();

	/**
	 * 返回该bean定义来自的资源的描述(以便在出现错误时显示上下文)。
	 */
	String getResourceDescription();

	/**
	 * 如果当前 BeanDefinition 是一个代理对象，那么该方法可以用来返回原始的 BeanDefinition
	 */
  BeanDefinition getOriginatingBeanDefinition();
  /************************************************************************************************/

}
