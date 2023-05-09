# **Spring依赖注入**
[相关问题](springDI/springDIQuestion.md)
## **Spring依赖注入概览**
###  **Spring依赖注入方式**
相关[代码实例]([/ioc-container-overview](https://github.com/FantasybabyChange/thinking-in-spring/blob/main/learn-ioc/ioc-container-overview/src/main/java/com/fantasybaby/spring/ioc/overview/SpringIocDiView.java))
* 根据 Bean 名称注入
* 根据 Bean 类型注入
  * 单个 Bean 对象
  * 集合 Bean 对象
* 注入容器內建 Bean 对象
* 注入非 Bean 对象
* 注入类型
  * 实时注入
  * 延迟注

## **依赖注入的模式以及类型**
### **注入模式**
 依赖注入分为**手动模式**以及**自动模式**
 1. 手动模式 - 配置或者编程的方式，提前安排注入规则
     * XML资源配置元信息
     * Java注解配置元信息
     * API配置元信息
 2. 自动模式 - 实现方提供以来自动关联的方式,按照内建的注入规则
    * [Autowiring](springDI/autowired.md)(自动绑定)
### **注入类型**
| 依赖注入类型 | 配置元数据举例 |
|-----|-----|
|Setter|方法 \<proeprty name=”user” ref=”userBean” />|
|构造器| \<constructor-arg name="user" ref="userBean" /> |
|字段|@Autowired User user;|
|方法|@Autowired public void user(User user) { ... }|
|接口回调|class MyBean implements BeanFactoryAware { ...} |