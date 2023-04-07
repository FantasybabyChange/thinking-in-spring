# **Spring Beans**
## **Bean的概念**
 **非Bean**: 非Spring 管理的bean.  
## **Spring Bean的命名**
[官方文档](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-beanname)
### **命名规范**
每个Bean拥有一个或多个标识符（identifiers），这些标识符在Bean所在的容器必须是唯一的。通常，一个Bean仅有一个标识符，如果需要额外的，可考虑使用别名（Alias）来
扩充。
在基于XML的配置元信息中，开发人员可用id或者name属性来规定Bean的标识符。通
常Bean的标识符由字母组成，允许出现特殊字符。如果要想引入Bean的别名的话，可在
name属性使用半角逗号（“,”）或分号（“;”)来间隔。
Bean的id或name 属性并非必须制定，如果留空的话，容器会为 Bean **自动生成一个唯一
的名称**。Bean 的命名尽管没有限制，不过官方建议采用驼峰的方式，更符合 Java 的命名约
定。
### **命名生成器**
Bean 名称生成器[BeanNameGenerator](https://github.com/spring-projects/spring-framework/blob/main/spring-beans/src/main/java/org/springframework/beans/factory/support/BeanNameGenerator.java)
 由 Spring Framework2.0.3引入，框架內建两种实现：
*  [DefaultBeanNameGenerator](https://github.com/spring-projects/spring-framework/blob/main/spring-beans/src/main/java/org/springframework/beans/factory/support/DefaultBeanNameGenerator.java)默认通用 BeanNameGenerator实现  
   源码中可以看出 如果是内部类会用 SEPARATOR(默认用\#\) 拼接,如果是一个唯一的Bean就会调用uniqueBeanName()方法
  ```java
  public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
		return BeanDefinitionReaderUtils.generateBeanName(definition, registry);
	}
  
  public static String generateBeanName(
			BeanDefinition definition, BeanDefinitionRegistry registry, boolean isInnerBean)
			throws BeanDefinitionStoreException {
    ...
		if (isInnerBean) {
			// Inner bean: generate identity hashcode suffix.
			return generatedBeanName + GENERATED_BEAN_NAME_SEPARATOR + ObjectUtils.getIdentityHexString(definition);
		}

		// Top-level bean: use plain class name with unique suffix if necessary.
		return uniqueBeanName(generatedBeanName, registry);
	}
  ```
* [AnnotationBeanNameGenerator](https://github.com/spring-projects/spring-framework/blob/main/spring-context/src/main/java/org/springframework/context/annotation/AnnotationBeanNameGenerator.java)：基于注解扫描的 BeanNameGenerator 实现，起始于 Spring
Framework 2.5.  
默认用简单的类名首字母小写. 如果有多个大写字母,原始大小写会被保留.其他规则与Java的[**java.beans.Introspector.decapitalize**](https://github.com/openjdk/jdk/blob/master/src/java.desktop/share/classes/java/beans/Introspector.java)中定义的相同
通过添加 Component, Repository, Service, Controller等注解 让Spring 容器扫描到对应的Bean.  
如果不是AnnotatedBeanDefinition实例 则会使用下面方法构建Bean.  
**注**:`**当前是Spring6.0+ 官方自己实现了 Introspector.decapitalize(shortClassName)**`
```java
protected String buildDefaultBeanName(BeanDefinition definition) {
		String beanClassName = definition.getBeanClassName();
		Assert.state(beanClassName != null, "No bean class name set");
		String shortClassName = ClassUtils.getShortName(beanClassName);
		//Spring自己实现了Introspector.decapitalize(shortClassName)
		return StringUtils.uncapitalizeAsProperty(shortClassName);
	}
```
### **SpringBean的别名**
Bean 别名（Alias）的价值
* 复用现有的 BeanDefinition
* 更具有场景化的命名方法，比如：
``` xml
	<alias name="user" alias="system1-bean"/>
    <alias name="user" alias="system2-bean"/>
```


## **BeanDefinition**  

 **BeanDefinition**: [BeanDefinition](https://github.com/spring-projects/spring-framework/blob/main/spring-beans/src/main/java/org/springframework/beans/factory/config/BeanDefinition.java) 是 Spring Framework 中定义 Bean 的配置元信息接口，包含：  
* Bean 的类名
* Bean 行为配置元素，如作用域、自动绑定的模式，生命周期回调等
* 其他 Bean 引用，又可称作合作者（collaborators）或者依赖（dependencies）
* 配置设置，比如 Bean
### **BeanDefinition元信息**
| 属性(Property)| 说明 |
|--- | --- |
|Class |Bean 全类名，必须是具体类，不能用抽象类或接口|
|Name |Bean 的名称或者 ID|
|Scope |Bean 的作用域（如：singleton、prototype 等）|
|Constructor arguments |Bean 构造器参数（用于依赖注入）|
|Properties |Bean 属性设置（用于依赖注入）|
|Autowiring mode |Bean 自动绑定模式（如：通过名称 byName）|
|Lazy initialization mode |Bean 延迟初始化模式（延迟和非延迟）|
|Initialization method |Bean 初始化回调方法名称|
|Destruction method |Bean 销毁回调方法名称|
### **BeanDefinition构建**
 * 通过 [BeanDefinitionBuilder](https://github.com/spring-projects/spring-framework/blob/main/spring-beans/src/main/java/org/springframework/beans/factory/support/BeanDefinitionBuilder.java)构建
 * 通过[AbstractBeanDefinition](https://github.com/spring-projects/spring-framework/blob/main/spring-beans/src/main/java/org/springframework/beans/factory/support/AbstractBeanDefinition.java)以及相关派生类  
[**相关代码**](../spring-beans-overview/src/main/java/com/fantasybaby/spring/beans/overview/BeanDefinitionBuildDemo.java)


## **FactoryBean**
 Interface to be implemented by objects used within a BeanFactory which are themselves factories for individual objects. If a bean implements this interface, it is used as a factory for an object to expose, not directly as a bean instance that will be exposed itself.  
 解决复杂的构造场景.  
 getObject: 会被容器调用  
 getObjectType:  获取对象类型  
 isSingleton: 是否是单例