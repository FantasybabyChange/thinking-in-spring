## **IOC 相关问题**
### **beanFacotry与applicationContext**
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
上面的问题参考在 [Springioc容器解释](../SpringWithIoC.md)
依赖注入和依赖查找的bean不相同  beanFactory为context   di中的对象为组合的对象
Application继承关系
ConfigurableApplicationContext <- ApplicationContext <- BeanFactory  
AbstractApplicationContext  getBeanFactory() -> ConfigurableApplicationContext#getBeanFactory() 
在AbstractRefreshableApplicationContext#getBeanFactory中使用了**组合模式** 所以在打印出来的对象为**DefaultListableBeanFactory**
```java
	/** Bean factory for this context. */
	@Nullable
	private volatile DefaultListableBeanFactory beanFactory;
  public final ConfigurableListableBeanFactory getBeanFactory() {
		DefaultListableBeanFactory beanFactory = this.beanFactory;
		return beanFactory;
    }
    org.springframework.beans.factory.support.DefaultListableBeanFactory@289d1c02: defining beans [user,user1,user2,objectFactory,userRepository]; root of factory hierarchy

```

### **Ioc面试题**
1. **什么是Spring Ioc**  
IoC is also known as dependency injection (DI). It is a process whereby objects define their dependencies (that is, the other objects they work with) only through constructor arguments, arguments to a factory method, or properties that are set on the object instance after it is constructed or returned from a factory method. The container then injects those dependencies when it creates the bean. This process is fundamentally the inverse (hence the name, Inversion of Control) of the bean itself controlling the instantiation or location of its dependencies by using direct construction of classes or a mechanism such as the Service Locator pattern.  
依赖注入和依赖查找(在javaEE已经被实现了)

2. **BeanFactory和FactoryBean有什么区别**  
   BeanFactory是Ioc底层容器
   FactoryBean是创建Bean的一种方式,帮助实现复杂的初始化逻辑
3. **Spring Ioc 容器启动时做了哪些准备？**  
    Ioc配置元心细读取和解析,Ioc容器生命周期,Spring事件发布,国际化等.