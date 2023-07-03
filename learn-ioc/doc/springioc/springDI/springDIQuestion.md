## **Spring依赖注入的问题**

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

**问题3**  
有多少种依赖注入的方式
* 构造器注入
* Setter 注入
* 字段注入
* 方法注入
* 接口回调注入  

**问题4**  
你偏好构造器注入还是 Setter 注入？  
两种依赖注入的方式均可使用，如果是必须依赖的话，那么推荐使用构
造器注入，Setter 注入用于可选依赖。
**问题5**    
Spring 依赖注入的来源有哪些?
