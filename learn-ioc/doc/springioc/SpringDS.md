# **Spring依赖来源**
[SpringBean的分类](../../../learn-spring-beans/doc/SpringBeans.md)

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

## **3. 依赖查找和注入来源的区别**
* Spring BeanDefinition: 是托管型Spring Bean的元数据
* 单体(singletonObjects) 注册的是外部已经注册的对象,已经初始化过的java对象,Spring容器中唯一.
* ResoveableDependency 主要是Spring内部对象,不需要重复创建

|来源|Spring Bean对象|生命周期管理|配置元信息|使用场景|
|-----|-----|-----|-----|-----|
|Spring BeanDefinition|是|是| 有| 依赖查找、依赖|
|单体对象|是|否|无|依赖查找、依赖注入|
|Resolvable Dependency|否|否|无 |依赖注入|
  
### **3.1 Spring BeanDefinition**
 [BeanDefintion 内容](../../../learn-spring-beans/doc/bean_lifecyle/SpringBeansDefinition.md)  
 [BeanDefintion 注册](../../../learn-spring-beans/doc/bean_lifecyle/SpringBeansCreateAndRegister.md)的实现
### **3.2 单体对象的注册**
[单体对象](../../../learn-spring-beans/doc/bean_lifecyle/SpringBeanSingleton.md)  
### **3.3 非Spring容器管理对象作为依赖来源**
[非Spring容器管理依赖来源](../../../learn-spring-beans/doc/bean_lifecyle/NoSpringBeanRegister.md)  

### **3.4 外部化配置作为依赖来源**
[通过外部配置注入](springDI/@Value.md)  