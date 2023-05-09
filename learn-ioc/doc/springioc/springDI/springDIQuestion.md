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