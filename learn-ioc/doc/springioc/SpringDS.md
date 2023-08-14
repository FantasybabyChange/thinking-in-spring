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