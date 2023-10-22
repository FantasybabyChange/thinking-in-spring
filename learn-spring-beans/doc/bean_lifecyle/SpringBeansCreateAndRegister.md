### **BeanDefinition构建**
  [BeanDefinition](../BeanDefinition.md)是用来描述一个Bean的接口
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

### **BeanDefinition注册的基本实现**
通过[BeanDefinitionRegistry#registerBeanDefinition](https://github.com/spring-projects/spring-framework/blob/main/spring-beans/src/main/java/org/springframework/beans/factory/support/BeanDefinitionRegistry.java)实现

这个方法的最终都是调用DefaultListableBeanFactory#registerBeanDefinition 下面理一下这个逻辑.

**一个HashMap 存放Bean的Name和定义 一个按照顺序存放Bean的Name**
```
private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);

private volatile List<String> beanDefinitionNames = new ArrayList<>(256);
```
方法具体实现:  
1.  对beanDefinition进行校验 这里与 BeanDefinitionBuilder#getBeanDefinition中的逻辑一致
```
   if (beanDefinition instanceof AbstractBeanDefinition abd) {
			try {
				abd.validate();
			}
			...
		}
```
2. 从BeanDefinition中查看是否已经有对应的BeanDefintion
```
BeanDefinition existingDefinition = this.beanDefinitionMap.get(beanName);
```
3. 如果有了
      
     * 会判断 allowBeanDefinitionOverriding 配置 是否覆盖该Bean
     * 判断角色大小
     * 判断是否已经存在
   ```
    if (!isAllowBeanDefinitionOverriding()) 
          else if (existingDefinition.getRole() < beanDefinition.getRole())
          else if (!beanDefinition.equals(existingDefinition))
          else {
            if (logger.isTraceEnabled())
          }
      
    ```  
     * 将该beanDefinition放入beanDefinitionMap中
    ```
      this.beanDefinitionMap.put(beanName, beanDefinition);
    ``` 
4. 如果没有
   * 判断是否为名称是否有alias
   * 判断Bean是否已经开始创建
    ```
      hasBeanCreationStarted()
    ```
   * 没有开始创建的Bean则放入Map 和 一个保持顺序的List集合中
   ```
    this.beanDefinitionMap.put(beanName, beanDefinition);
		this.beanDefinitionNames.add(beanName);
   ``` 
