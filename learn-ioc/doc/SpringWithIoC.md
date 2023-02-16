# **Spring 与Ioc**
## **IOC是什么**
根据 [wiki](https://en.wikipedia.org/wiki/Inversion_of_control)
在软件工程中, inversion of control（IoC） 是一个设计模式,在计算机程序自定义写的部分从通用框架重 收到控制流(我觉得意思是你写的那部分是框架统一控制). 一个使用这种反转控制的软件架构对比传统程序: 
传统的程序重,自定义的代码在可重用的函数库处理广泛的任务中表达程序调用的目的 , 而Ioc则是程序调用定制或者任务特定的代码

## **IOC的简史**
* 1983年，Richard E. Sweet 在《The Mesa Programming Environment》中提出“Hollywood
* Principle”（好莱坞原则）
* 1988年，Ralph E. Johnson & Brian Foote 在《Designing Reusable Classes》中提出“Inversion
* of control”（控制反转）
* 1996年，Michael Mattsson 在《Object-Oriented Frameworks, A survey of methodological issues》中将“Inversion of control”命名为 “Hollywood principle”
* 2004年，Martin Fowler 在《Inversion of Control Containers and the Dependency Injection pattern》中提出了自己对 IoC 以及 DI 的理解
* 2005年，Martin Fowler 在 《InversionOfControl》对 IoC 做出进一步的说

## IoC 实现策略
根据 [wiki](https://en.wikipedia.org/wiki/Inversion_of_control)  
在面向对象的程序中, 有多种技术实现IoC:
* 使用服务定位(Service locator pattern) 
	JavaEE中定义 使用JNDI的技术实现
* 使用依赖注入(dependency injection DI):spring 和 EJB3.0都支持
	* 构造器注入
	* 参数注入
	* Setter 注入
	* 方法注入
* 使用上下文查找  
  java beans 中使用 beanContext实现
* 使用模板方法设计模式  
   spring-jdbc使用到
* 使用策略设计模式

### Spring实现IOC的主要策略
* 依赖查找(Dependency Lookup): 容器提供一个回调给组件, 并且给一个 上下文查找(lookup context). EJB和apache Avalon 实现了这种模式. 这让每个组件都有责任使用 容器的API来查看资源和协作者. 控制反转局限于 容器调用 回调方法,应用程序代码可以用来获取资源
* 依赖注入(Dependency Injection): 组件不查找,他们提供Java 方法来让容器解决以来. 容器对于组件连接负全责. 将对应的对象传给 JavaBean属性或者构造器. 通过JavaBean属性 叫做Setter 注入,使用构造器参数的叫做构造器注入.

### Ioc设计目的
根据 [wiki](https://en.wikipedia.org/wiki/Inversion_of_control)  
Ioc 的设计目的
* 将任务的执行和实现分离出来
* 关注于设计这个任务的模块本身.
* 从猜测别的系统怎么做他们的实现解放模块,使用 合约替换猜测
* 解耦 防止更换模块时产生的副作用.
### Spring中IoC容器的职责
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
  
### IoC容器的实现
* JavaSe
  * Java Beans
  * Java ServiceLoader SPI
  * JNDI
* Java EE
  * EJB(Enterprise Java Beans)
  * Servlet
* 开源
  * ~~[Apache Avalon](http://avalon.apache.org/closed.html)~~ 已经没了
  * [PicoContainer](http://picocontainer.com/)
  * [Google Guice](https://github.com/google/guice)
  * [Spring Framework](https://spring.io/projects/spring-framework)