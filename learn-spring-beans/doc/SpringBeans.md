# **Spring Beans Overview**
## **Bean的概念**
 **非Bean**: 非Spring 管理的bean.  
## **Spring Bean的命名**
[Spring bean Naming](../doc/bean_lifecyle/SpringBeanNaming.md)
## **BeanDefinition**  
[Spring bean definition](../doc/bean_lifecyle/SpringBeansDefinition.md)
## **FactoryBean**
 Interface to be implemented by objects used within a BeanFactory which are themselves factories for individual objects. If a bean implements this interface, it is used as a factory for an object to expose, not directly as a bean instance that will be exposed itself.  
 解决复杂的构造场景.  
 getObject: 会被容器调用  
 getObjectType:  获取对象类型  
 isSingleton: 是否是单例