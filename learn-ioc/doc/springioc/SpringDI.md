# **Spring依赖注入**
[相关问题](springDI/springDIQuestion.md)
## **Spring依赖注入概览**
###  **Spring依赖注入方式**
相关[代码实例](/learn-ioc/ioc-container-overview/src/main/java/com/fantasybaby/spring/ioc/overview/di/SpringIocDiView.java)
* 根据 Bean 名称注入
* 根据 Bean 类型注入
  * 单个 Bean 对象
  * 集合 Bean 对象
* 注入容器內建 Bean 对象
* 注入非 Bean 对象
* 注入类型
  * 实时注入
  * 延迟注入

## **依赖注入的模式以及类型**
### **注入模式**
 依赖注入分为**手动模式**以及**自动模式**
 1. 手动模式 - 配置或者编程的方式，提前安排注入规则
     * XML资源配置元信息
     * Java注解配置元信息
     * API配置元信息
 2. 自动模式 - 实现方提供以来自动关联的方式,按照内建的注入规则
    * [Autowiring](springDI/autowired.md)(自动绑定)
### **注入方式**
| 依赖注入方式                                   | 配置元数据举例                                  |
| ---------------------------------------------- | ----------------------------------------------- |
| [Setter](springDI/setterAndConstructorDi.md)   | 方法 \<proeprty name=”user” ref=”userBean” />   |
| [构造器](springDI/setterAndConstructorDi.md)   | \<constructor-arg name="user" ref="userBean" /> |
| [字段](springDI/setterAndConstructorDi.md)     | @Autowired User user;                           |
| [方法](springDI/setterAndConstructorDi.md)     | @Autowired public void user(User user) { ... }  |
| [接口回调](springDI/setterAndConstructorDi.md) | class MyBean implements BeanFactoryAware { ...} |
### **基础类型注入**
 * 原生类型（Primitive）：boolean、byte、char、short、int、float、long、double
* 标量类型（Scalar）：Number、Character、Boolean、Enum、Locale、Charset、Currency、Properties、UUID
* 常规类型（General）：Object、String、TimeZone、Calendar、Optional 等
* Spring 类型：[Resource](https://github.com/spring-projects/spring-framework/blob/main/spring-core/src/main/java/org/springframework/core/io/Resource.java)、[InputSource](https://github.com/openjdk/jdk/blob/master/src/java.xml/share/classes/org/xml/sax/InputSource.java)、[Formatter](https://github.com/openjdk/jdk/blob/master/src/java.base/share/classes/java/util/Formatter.java) 等

### **集合类型注入**
* 数组类型（Array）：原生类型、标量类型、常规类型、Spring 类型
* 集合类型（Collection）
  * Collection：List、Set（SortedSet、NavigableSet、EnumSet）
  * Map：Properties
## **使用注解依赖注入**
使用[@Autowired](springDI/%40Autowired.md) JSR 330的 @Inject, 以及 @Value @Resource 这些注解都会被[BeanPostProcessor ](https://github.com/spring-projects/spring-framework/blob/main/spring-beans/src/main/java/org/springframework/beans/factory/config/BeanPostProcessor.java)处理
### **依赖注入限定**
* **@Primary**  
在一些情况下,我们有自动装配时有多个候选Bean，这个时候通常需要控制选择过程.通过使用 [@Primary](https://github.com/spring-projects/spring-framework/blob/main/spring-context/src/main/java/org/springframework/context/annotation/Primary.java)注解来表明标注的Bean是需要有限考虑的  
* **@Qualifier**  
在一些场景下我们需要对不同的实例进行限定以及分组,可以使用[@Qualifier](https://github.com/spring-projects/spring-framework/blob/main/spring-beans/src/main/java/org/springframework/beans/factory/annotation/Qualifier.java)
 [代码演示](../../ioc-dependency-inject\src\main\java\com\fantasybaby\spring\ioc\inject\selection\QualifiersNameInjectDemo.java)  
1. 限定Bean  
     * 通过名称限定
     * 通过分组限定
2. 扩展Qualifier
     * 自定义注解 - 如 Spring Cloud [@LoadBalanced](https://github.com/spring-cloud/spring-cloud-commons/blob/main/spring-cloud-commons/src/main/java/org/springframework/cloud/client/loadbalancer/LoadBalanced.java)
```java
@Qualifier
public @interface LoadBalanced {

}
```
### **依赖延迟注入**
[代码](../../ioc-dependency-inject/src/main/java/com/fantasybaby/spring/ioc/inject/lazy/LazyInjectDemo.java)
1. 使用 API ObjectFactory 延迟注入
     * 单一类型
     * 集合类型
2. 使用 API ObjectProvider 延迟注入（推荐）
      * 单一类型
      * 集合类型


### **Spring依赖解析**
当依赖查询到后Spring会对依赖进行解析
接口 [AutowireCapableBeanFactory](https://github.com/spring-projects/spring-framework/blob/main/spring-beans/src/main/java/org/springframework/beans/factory/config/AutowireCapableBeanFactory.java)#resolveDependency
[具体过程](springDI/dependencyResolve.md)

