# **Spring依赖查找**
## Spring依赖查找概览
  Spring依赖查找
* 根据 Bean 名称查找
  * 实时查找  通过 beanFactory.getBean
  * 延迟查找  通过 objectFactory.getObject()
* 根据 Bean 类型查找
  *  单个 Bean 对象
  *  集合 Bean 对象
  *  根据 Bean 名称 + 类型查找
* 根据 Java 注解查找
  * 单个 Bean 对象
  * 集合 Bean 对象  
  
[代码实例](/ioc-container-overview)