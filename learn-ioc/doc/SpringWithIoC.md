# **Spring 与Ioc**

### **Spring实现IOC的主要策略**
* 依赖查找(Dependency Lookup): 容器提供一个回调给组件, 并且给一个 上下文查找(lookup context). EJB和apache Avalon 实现了这种模式. 这让每个组件都有责任使用 容器的API来查看资源和协作者. 控制反转局限于 容器调用 回调方法,应用程序代码可以用来获取资源
* 依赖注入(Dependency Injection): 组件不查找,他们提供Java 方法来让容器解决以来. 容器对于组件连接负全责. 将对应的对象传给 JavaBean属性或者构造器. 通过JavaBean属性 叫做Setter 注入,使用构造器参数的叫做构造器注入.
### **Spring中IoC容器的职责**
通用职责
* 依赖处理
  * 依赖查找
  * 依赖注入
* 生命周期管理
  * 容器 自生的创建 启动 停止 暂停 销毁等
  * 托管的资源(Java Beans 或其他资源 比如事件)
* 配置
	* 容器自身配置
	* 外部化配置
	* 托管的资源(Java Beans 或其他资源)
  
### **Spring依赖查找以及依赖注入**
* [Spring依赖查找](SpringDL.md)  
* [Spring依赖注入](SpringDI.md)
#### **Ioc依赖来源**
相关[代码来自]([/ioc-container-overview](https://github.com/FantasybabyChange/thinking-in-spring/blob/main/learn-ioc/ioc-container-overview/src/main/java/com/fantasybaby/spring/ioc/overview/SpringIocDiView.java))
* 自定义Bean
```java
//获取自定义bean
UserRepository userRepository = (UserRepository) beanFactory.getBean("userRepository");
```
* 容器内建 Bean 对象
```java
// 获取依赖创建的bean
System.out.println(userRepository.getBeanFactory());
```
* 容器内建依赖
```java
// 获取依赖创建的bean
Environment bean = beanFactory.getBean(Environment.class);
```

## **Spring Ioc配置元信息**
* Bean 定义配置
  * 基于 XML 文件
  * 基于 Properties 文件
  * 基于 Java 注解
  * 基于 Java API（专题讨论）
  * groovy
* IoC 容器配置
*   基于 XML 文件
*   基于 Java 注解
*   基于 Java API （专题讨论）
* 外部化属性配置
  * 基于 Java 注解
