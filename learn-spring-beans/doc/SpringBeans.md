# **Spring Beans Overview**
## **Bean的概念**
 **非Bean**: 非Spring 管理的bean.  

## **Bean的生命周期**
### **Spring Bean的命名**
[Spring bean Naming](../doc/bean_lifecyle/SpringBeanNaming.md)
### **Bean的定义创建注册**  
[Spring bean definition](../doc/bean_lifecyle/SpringBeansDefinition.md)
### **Bean的实例化**  
[Spring bean instantiation](../doc/bean_lifecyle/SpringBeansInstantiation.md)
### **Bean的初始化**  
[Spring bean initialization](../doc/bean_lifecyle/SpringBeansInitialization.md)
### **Bean的销毁**  
[Spring bean initialization](../doc/bean_lifecyle/SpringBeansInitialization.md)
### **Bean的垃圾回收**  
Bean 垃圾回收（GC）
1. 关闭 Spring 容器（应用上下文）
2. 执行 GC
3. Spring Bean 覆盖的 finalize() 方法被回
### **FactoryBean**
 Interface to be implemented by objects used within a BeanFactory which are themselves factories for individual objects. If a bean implements this interface, it is used as a factory for an object to expose, not directly as a bean instance that will be exposed itself.  
 解决复杂的构造场景.  
 getObject: 会被容器调用  
 getObjectType:  获取对象类型  
 isSingleton: 是否是单例