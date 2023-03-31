# **Spring Beans**
## Bean的概念
 **非Bean**: 非Spring 管理的bean.  
 **BeanDefinition**: [BeanDefinition](https://github.com/spring-projects/spring-framework/blob/main/spring-beans/src/main/java/org/springframework/beans/factory/config/BeanDefinition.java) 是 Spring Framework 中定义 Bean 的配置元信息接口，包含：  
* Bean 的类名
* Bean 行为配置元素，如作用域、自动绑定的模式，生命周期回调等
* 其他 Bean 引用，又可称作合作者（collaborators）或者依赖（dependencies）
* 配置设置，比如 Bean
## FactoryBean
 Interface to be implemented by objects used within a BeanFactory which are themselves factories for individual objects. If a bean implements this interface, it is used as a factory for an object to expose, not directly as a bean instance that will be exposed itself.  
 解决复杂的构造场景.  
 getObject: 会被容器调用  
 getObjectType:  获取对象类型  
 isSingleton: 是否是单例