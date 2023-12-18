## **依赖来源 相关问题**
### 1. 依赖注入和依赖查找来源是否相同 
是不同的查找来源于单例对象和BeanDefinition,依赖注入来源还有 依赖解决(Resolvable Dependency) 以及@Value的外部化配置

### 2. 单例对象能在Ioc容器启动后注册吗
是可以的,单例对象的注册与BeanDefinition不同,BeanDefinition会调用 
    [DefaultListableBeanFactory](https://github.com/spring-projects/spring-framework/blob/main/spring-beans/src/main/java/org/springframework/beans/factory/support/DefaultListableBeanFactory.java)#freezeConfiguration() 冻结注册,单例对象(参考SingletonBeanRegistry->DefaultSingletonBeanRegistry)并没有这个限制.

### 3.Spring 依赖注入的来源有哪些?
Spring BeanDefinition 单例对象  Resovable Dependency @Value 外部化 配置