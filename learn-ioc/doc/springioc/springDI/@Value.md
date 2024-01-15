## **使用@Value注入**
@Value和@Autowired都是通过[AutowiredAnnotationBeanPostProcessor](https://github.com/spring-projects/spring-framework/blob/main/spring-beans/src/main/java/org/springframework/beans/factory/annotation/AutowiredAnnotationBeanPostProcessor.java)加载进入processor中

### 外部化配置
非常规Spring对象依赖来源
@Value可以让外部化配置注入到Spring容器中

### 实现原理
先简单总结一下使用类。  
1. DefaultListableBeanFactory.doResolveDependency()中 通过 			
``` java
Object value = getAutowireCandidateResolver().getSuggestedValue(descriptor);
```
 当前value为${placeholder}  
 2. 方法resolveEmbeddedValue()  使用 embeddedValueResolvers()方法找到对应的reslover来解析当前占位符.  
 3. **StringValueResolver**的一个回调函数实现  PropertyPlaceholderHelper#parseStringValue()
