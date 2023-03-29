# **Spring依赖注入**
## **Spring依赖注入概览**
###  **Spring依赖注入方式**
相关[代码实例]([/ioc-container-overview](https://github.com/FantasybabyChange/thinking-in-spring/blob/main/learn-ioc/ioc-container-overview/src/main/java/com/fantasybaby/spring/ioc/overview/SpringIocDiView.java))
* 根据 Bean 名称注入
* 根据 Bean 类型注入
  * 单个 Bean 对象
  * 集合 Bean 对象
* 注入容器內建 Bean 对象
* 注入非 Bean 对象
* 注入类型
  * 实时注入
  * 延迟注

**问题1**  
注入的beanFactory和使用的beanFactory为什么不相等
```java 
System.out.println("beanFactory== user.beanFactory " + (beanFactory == userRepository.getBeanFactory()));
```
**问题2**  
beanFactory为什么和注入的context是相同的 
```java
System.out.println("beanFactory和注入的context 是否相等 "+(userRepository.getApplicationContextObjectFactory().getObject() == beanFactory));
```