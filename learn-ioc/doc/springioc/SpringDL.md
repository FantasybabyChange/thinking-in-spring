# **Spring依赖查找**
### **Spring依赖查找概览**
### **Spring依赖查找**
  相关[代码实例]([/ioc-container-overview](https://github.com/FantasybabyChange/thinking-in-spring/blob/main/learn-ioc/ioc-container-overview/src/main/java/com/fantasybaby/spring/ioc/overview/SpringIocLookUp.java))
* 根据 Bean 名称查找
  * 实时查找  通过 beanFactory.getBean
  * 延迟查找  通过 objectFactory.getObject()
* 根据 Bean 类型查找
  *  单个 Bean 对象
  *  集合 Bean 对象  ListableBeanFactory.getBeansOfType()
  *  根据 Bean 名称 + 类型查找
  *  通过注解查找bean listBeanFactory.getBeansWithAnnotation(UserLook.class);
* 根据 Java 注解查找
  * 单个 Bean 对象
  * 集合 Bean 对象  

### **Spring依赖查找类型**  
#### **1. 单一类型依赖查找接口**
通过[BeanFactory](https://github.com/spring-projects/spring-framework/blob/main/spring-beans/src/main/java/org/springframework/beans/factory/BeanFactory.java)来查找单一类型的Bean
   * 根据 Bean 名称查找
     * **getBean(String)**
     * Spring 2.5 覆盖默认参数：getBean(String,Object...) `不建议使用`
   * 根据 Bean 类型查找
     * Bean 实时查找
       * Spring 3.0 **getBean**(Class)
       * Spring 4.1 覆盖默认参数：getBean(Class,Object...) `不建议使用`
   * Spring 5.1 Bean 延迟查找ObjectProvider
     * **getBeanProvider(Class)**
     * **getBeanProvider(ResolvableType)** 
      ResolvableType  Type 用来处理多类型
   * 根据 Bean 名称 + 类型查找：getBean(String,Class)
  
#### **2. 集合类型依赖查找接口** 
  [**ListableBeanFactory**](https://github.com/spring-projects/spring-framework/blob/main/spring-beans/src/main/java/org/springframework/beans/factory/ListableBeanFactory.java) 可以查找集合接口(Collection Map List Set)  
  当使用类型去查找Bean的时候,需要注意有的Bean可能会被提前初始化,所以建议使用name查询,判断bean是否存在.  
  根据 Bean 类型查找名称和实例.  查找实例需要Bean初始化
  * 获取同类型 Bean 名称列表   
    通过FactoryBean#getObjectType() 或者 BeanDefinition#getBeanClassName() 来判断
    * getBeanNamesForType(Class)
    * Spring 4.2 getBeanNamesForType(ResolvableType)
  * 获取同类型 Bean 实例列表
    * getBeansOfType(Class) 以及重载方法
  * 通过注解类型查找
    * Spring 4.0 获取标注类型 Bean 名称列表
      * getBeanNamesForAnnotation(Class<? extends Annotation>)
    * Spring 3.0 获取标注类型 Bean 实例列表
      * getBeansWithAnnotation(Class<? extends Annotation>)
    * Spring 3.0 获取指定名称 + 标注类型 Bean 实例
      * findAnnotationOnBean(String,Class<? extends Annotation
#### **3. 层次性依赖查找接口**
 HierarchicalBeanFactory
* 双亲 BeanFactory：getParentBeanFactory()
* 层次性查找
  * 根据 Bean 名称查找(官方没有实现 ,可以使用递归查找)
    * 基于 containsLocalBean 方法实现
    ```java
     private static boolean containsBean(HierarchicalBeanFactory beanFactory, String beanName) {
        BeanFactory parentBeanFactory = beanFactory.getParentBeanFactory();
        if (parentBeanFactory instanceof HierarchicalBeanFactory) {
            HierarchicalBeanFactory parentHierarchicalBeanFactory = HierarchicalBeanFactory.class.cast(parentBeanFactory);
            if (containsBean(parentHierarchicalBeanFactory, beanName)) {
                return true;
            }
        }
        return beanFactory.containsLocalBean(beanName);
    }
    ```
  * 根据 Bean 类型查找实例列表
    * 单一类型：BeanFactoryUtils#beanOfType
    * 集合类型：BeanFactoryUtils#beansOfTypeIncludingAncestors
  * 根据 Java 注解查找名称列表
    * BeanFactoryUtils#beanNamesForTypeIncludingAncestors

#### **4. 延迟依赖查找**
1. **spring 1.0.2**  
 通过[ObjectFactory#getObject()](https://github.com/spring-projects/spring-framework/blob/main/spring-beans/src/main/java/org/springframework/beans/factory/ObjectFactory.java)的 [ObjectFactoryCreatingFactoryBean](https://github.com/spring-projects/spring-framework/blob/main/spring-beans/src/main/java/org/springframework/beans/factory/config/ObjectFactoryCreatingFactoryBean.java) 来实现延时加载
 ```java
      ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
      User user = objectFactory.getObject();
 ```
2.  **Spring 5.1之后**
   通过 [BeanFactory#getBeanProvider](https://github.com/spring-projects/spring-framework/blob/main/spring-beans/src/main/java/org/springframework/beans/factory/BeanFactory.java)
     
     获取[**ObjectProvider**](https://github.com/spring-projects/spring-framework/blob/main/spring-beans/src/main/java/org/springframework/beans/factory/ObjectProvider.java)  
     ObjectProvider 继承于 ObjectFactory
* 函数式接口  
    * getIfAvailable(Supplier)
    * ifAvailable(Consumer)  
* Stream 扩展 - stream