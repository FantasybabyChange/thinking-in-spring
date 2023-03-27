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
  