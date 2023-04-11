### **BeanDefinition构建**
 * 通过 [BeanDefinitionBuilder](https://github.com/spring-projects/spring-framework/blob/main/spring-beans/src/main/java/org/springframework/beans/factory/support/BeanDefinitionBuilder.java)构建
 * 通过[AbstractBeanDefinition](https://github.com/spring-projects/spring-framework/blob/main/spring-beans/src/main/java/org/springframework/beans/factory/support/AbstractBeanDefinition.java)以及相关派生类  
[**相关代码**](../../spring-beans-overview/src/main/java/com/fantasybaby/spring/beans/overview/BeanDefinitionBuildDemo.java)

### **Bean的注册**
Spring Bean有以下几种注册方式
1. XML 使用 <Bean name /> 标签  
	使用Annotation MetaData
2. 使用注解
  AnnotationConfigApplicationContext.register 注册配置类
   * @Bean
   * @Import
   * @Component
3. 使用api注册
   * 命名方式BeanDefinitionRegistry.registerBeanDefinition(String, BeanDefinition)
   * 非命名方式 org.springframework.beans.factory.support.BeanDefinitionReaderUtils.registerWithGeneratedName(AbstractBeanDefinition, BeanDefinitionRegistry)
   * 配置类方式 org.springframework.context.annotation.AnnotatedBeanDefinitionReader.register(Class[])
   * 外部单例对象注册
     * Java API 配置元信息
     * SingletonBeanRegistry#registerSingleton
