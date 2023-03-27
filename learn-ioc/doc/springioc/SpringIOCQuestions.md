## **IOC 相关问题**
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
上面的问题参考在 [Springioc容器解释](../doc/SpringWithIoC.md)
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
