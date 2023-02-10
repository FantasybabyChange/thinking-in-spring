# Spring 编程模型
![图片](../doc/pics/Spring%20Programming%20Module.png)
## 面向对象编程
### 1 **契约接口**
 1. [**Aware**](https://github.com/spring-projects/spring-framework/blob/main/spring-beans/src/main/java/org/springframework/beans/factory/Aware.java) 接口  
 是spring 3.1提供的接口,这种接口的实现接口 一般是  **类型+ Aware**  其中会有**set+类型** 的方法 在bean实现接口的时候,会回调把对应类型传递过去. 
比如 [ApplicationContextAware](https://github.com/spring-projects/spring-framework/blob/main/spring-context/src/main/java/org/springframework/context/ApplicationContextAware.java),[BeanFactoryAware](https://github.com/spring-projects/spring-framework/blob/main/spring-beans/src/main/java/org/springframework/beans/factory/BeanFactoryAware.java) 等
```java 
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
```
2. [**BeanPostProcessor**](https://github.com/spring-projects/spring-framework/blob/main/spring-beans/src/main/java/org/springframework/beans/factory/config/BeanPostProcessor.java)  
   关于bean的生命周期的后置处理 before和 fater
```java
    default Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
            return bean;
        }
	@Nullable
	default Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}
```
### 2 **设计模式**
1. 观察者模式
    ApplicationEvent  EventObject SimpleApplicationEventMulticaster简单实现
2. 组合模式
   CompositeCacheManager  继承了 CacheManager 也自定义了 来实现
   ``` java
   	private final List<CacheManager> cacheManagers = new ArrayList<>();
   ```
3. 模板模式  
   [JdbcTemplate](https://github.com/spring-projects/spring-framework/blob/main/spring-jdbc/src/main/java/org/springframework/jdbc/core/JdbcTemplate.java) 这个得action callback就是使用的模板设计模式
```java
    public <T> T execute(ConnectionCallback<T> action) throws DataAccessException {
		Assert.notNull(action, "Callback object must not be null");
    ...
			return action.doInConnection(conToUse);
		}
	...
	}
```

### 3 **对象继承**
  比如 AbstractApplicationContext 等抽象类有很多的实现

## **面向切面**
 [AopProxy](https://github.com/spring-projects/spring-framework/blob/main/spring-aop/src/main/java/org/springframework/aop/framework/AopProxy.java)
 ### **1.动态代理**
经典动态代理实现[JdkDynamicAopProxy](https://github.com/spring-projects/spring-framework/blob/main/spring-aop/src/main/java/org/springframework/aop/framework/JdkDynamicAopProxy.java)
### **2.cglib**
[CglibAopProxy](https://github.com/spring-projects/spring-framework/blob/main/spring-aop/src/main/java/org/springframework/aop/framework/CglibAopProxy.java)将 cglib 
[Enhancer](https://github.com/spring-projects/spring-framework/blob/main/spring-core/src/main/java/org/springframework/cglib/proxy/Enhancer.java) Asm等内联

## 面向元编程
### **模式注解**
 基于DDD引出的概念  
  [Component](https://github.com/spring-projects/spring-framework/blob/main/spring-context/src/main/java/org/springframework/stereotype/Component.java)
  可以使用[ComponentScan ](https://github.com/spring-projects/spring-framework/blob/main/spring-context/src/main/java/org/springframework/context/annotation/ComponentScan.java)扫描
  Component的派生   @Service @Repository
  ### **配置**
  Environment  profiles  
  PropertyResolver  getProperty   PropertySource
  ### **泛型**
  GenericTypeResolver

  ResolvableType 将Map泛型的类型找出   
  ParameterizedType java 提供的api 不太好用
  ## 函数驱动
  ### 函数接口
  ## 模块驱动
