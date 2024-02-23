## Singleton bean scope
只有一个共享的实例在容器中被管理, 所有对这个bean的请求通过 Id或者ids关联并由Spring容器返回.
![单例示意图](https://docs.spring.io/spring-framework/reference/_images/singleton.png)

### Spring判断方式
DefaultListableBeanFactory.isSingleton() 通过beanDefinition元信息判断.
```java
private boolean isSingleton(String beanName, RootBeanDefinition mbd, @Nullable BeanDefinitionHolder dbd) {
		return (dbd != null ? mbd.isSingleton() : isSingleton(beanName));
	}
```