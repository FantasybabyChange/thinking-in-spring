# **非Spring容器管理的对象**
ResolvableDependecy:非Spring容器管理的对象
## **非常规的Spring对象依赖来源**
**限制**  
* 无生命周期管理
* 无法实现延迟初始化 Bean
* 无法通过依赖查找
## **注册方法**
[Demo](../../../learn-ioc/ioc-dependency-sources/src/main/java/com/fantasybaby/spring/ioc/source/reslove/ResolvableDependencySourceDemo.java)
[ConfigurableListableBeanFactory](https://github.com/spring-projects/spring-framework/blob/main/spring-beans/src/main/java/org/springframework/beans/factory/config/ConfigurableListableBeanFactory.java)#registerResolvableDependency


AbstractApplicationContext中的refresh()方法 invokeBeanFactoryPostProcessors()会回调FactoryPostProcessor 早于Bean的初始化