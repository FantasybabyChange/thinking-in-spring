# **Spring依赖来源**
## **1.依赖查找来源**
|来源|配置元数据|
|----|----|
|Spring BeanDefinition| \<bean id="user" class="org...Object">|
|| @Bean|
|| BeanDefinitionBuilder|
|单例对象| 使用api实现|

Spring内建的BeanDefinition和Spring内建的单例,具体的Bean内容再 [Spring依赖查找中](SpringDL.md)
 
 1. **\<context:annotation-config/>**  AnnotationConfigBeanDefinitionParser ->  AnnotationConfigUtils.registerAnnotationConfigProcessors
 2. **\<context:component-scan/>**  ComponentScanBeanDefinitionParser ->  scanner.doScan(basePackages);
 3. AnnotatedBeanDefinitionReader ->  AnnotatedBeanDefinitionReader -> AnnotationConfigUtils.registerAnnotationConfigProcessors
 4. 注册单例的bean AbstractApplicationContext -> prepareBeanFactory() 
## **2.依赖注入来源**
|来源|配置元数据|
|----|----|
|Spring BeanDefinition| \<bean id="user" class="org...Object">|
|| @Bean|
|| BeanDefinitionBuilder|
|单例对象| 使用api实现|
|非Spring容器管理的Bean| resolvableDependencies注册的Bean 当前的context和beanFactory|

下面代码是拷贝[AbstractApplicationContext#prepareBeanFactory](https://github.com/spring-projects/spring-framework/blob/main/spring-context/src/main/java/org/springframework/context/support/AbstractApplicationContext.java) 的代码,可以看到Sprng在启动的时候通过registerResolvableDependency注册了四个非Spring容器管理的Bean,
在DefaultListableBeanFactory#resolvableDependencies这个ConcurrentHashMap中
1. BeanFactory  
2. ResourceLoader
3. ApplicationEventPublisher
4. ApplicationContext
其中出了第一个BeanFactory外 其他三个都是相同的(`这些Bean不能通过BeanFactory的getBean获取`)
```java
    		// BeanFactory interface not registered as resolvable type in a plain factory.
		// MessageSource registered (and found for autowiring) as a bean.
		beanFactory.registerResolvableDependency(BeanFactory.class, beanFactory);
		beanFactory.registerResolvableDependency(ResourceLoader.class, this);
		beanFactory.registerResolvableDependency(ApplicationEventPublisher.class, this);
		beanFactory.registerResolvableDependency(ApplicationContext.class, this);
```