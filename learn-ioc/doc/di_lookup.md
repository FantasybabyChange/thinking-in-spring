## **依赖查找以及依赖注入**
### **依赖查找以及依赖注入的对比**
|类型|依赖处理|实现便利性|代码侵入性 API|依赖性|可读性|
|---|---|---|---|---|---|
|依赖查找|主动获取|相对繁琐|侵入业务逻辑|依赖容器API|良好|
|依赖注入| 被动提供| 相对便利| 低侵入性| 不依赖容器| 一般|

### **构造器注入 与 Setter注入**
#### **SpringFramework的看法**
* 更推荐构造器注入, 可以使你的应用组件实现为不可变对象并且确保你需要的依赖不为null.另外 构造器注入的组件总会返回客户端调用的代码一个完整的初始化后状态. 另外大量的构造器参数是一个坏味道, 这意味着我们需要重构来做到更好的关注点分离
* Setter注入则主要应用于可选依赖，可选依赖可以在类中分配合理默认值的.否则not-null检查必须随时监控代码使用的依赖. 一个Setter注入的好处是 可以让对象的类之后容易重新注入和重新配置. 所以使用JMX MBeans管理Setter 注入刻不容缓呀
* 构造器注入不会出现循环依赖
#### **Expert One-on-One J2EE Development withou EJB**的看法
1. 更推荐Setter注入  
**优点**
   * JavaBean属性被IDE支持的更好
   * JavaBean自文档
   * JavaBean属性可以被子类继承
   * 可以使用标准的 JavaBean **property-editor**(PropertyEditorSupport)机制来进行类型转换
   * 大量已存在的JavaBean可以在 面向JavaBean容器中很好的适配
   * 有对应的Getter可以获取到属性的状态, 如果使用构造器注入则不能很好的查看状态
   * Setter 也同样适用于有默认值的对象,这意味着不是所有属性需要实时提供  
**缺点**
   * Setter的顺序没有办法约束  Srping提供了[InitializingBean](https://github.com/spring-projects/spring-framework/blob/main/spring-beans/src/main/java/org/springframework/beans/factory/InitializingBean.java)能够调用任意的初始方法,不过这个必须有在文档上约定,以防超出容器外.  
1. 构造器注入  
**优点**    
    * 在调用前是一个确定的状态. 
    * 减小代码量
**缺点**    
    * 多参构造器不常用
    * 构造器参数名称不能自省
    * IDEs中对于构造器参数的展示没有Setter方法展示的好
    * 长的构造参数和打的构造方法body很笨拙
    * 具体的继承可能会存在问题
    * 对于可选属性对比JavaBeans来说很贫瘠
    * 单元测试稍微难一些
    * 当其他对象被传递到当前对象的构造器后,所持有的引用将不能被改变