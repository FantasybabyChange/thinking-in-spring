# **Spring Beans Definition**
## **BeanDefinition**  
 **BeanDefinition**: [BeanDefinition](https://github.com/spring-projects/spring-framework/blob/main/spring-beans/src/main/java/org/springframework/beans/factory/config/BeanDefinition.java) 是 Spring Framework 中定义 Bean 的配置元信息接口，包含：  
* Bean 的类名
* Bean 行为配置元素，如作用域、自动绑定的模式，生命周期回调等
* 其他 Bean 引用，又可称作合作者（collaborators）或者依赖（dependencies）
* 配置设置，比如 Bean
### **BeanDefinition元信息**
| 属性(Property)| 说明 |
|--- | --- |
|Class |Bean 全类名，必须是具体类，不能用抽象类或接口|
|Name |Bean 的名称或者 ID|
|Scope |Bean 的作用域（如：singleton、prototype 等）|
|Constructor arguments |Bean 构造器参数（用于依赖注入）|
|Properties |Bean 属性设置（用于依赖注入）|
|Autowiring mode |Bean 自动绑定模式（如：通过名称 byName）|
|Lazy initialization mode |Bean 延迟初始化模式（延迟和非延迟）|
|Initialization method |Bean 初始化回调方法名称|
|Destruction method |Bean 销毁回调方法名称|

| 方法| 说明 |
|--- | --- |
|**getBeanClassName** |  返回当前类的名称|
### **BeanDefinition构建与注册**
   [BeanDefinition构建与注册](SpringBeansCreateAndRegister.md)
