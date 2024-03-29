# Thinking-in-spring
本项目是根据小马哥
[教程仓库](https://gitee.com/geektime-geekbang/geekbang-lessons)
自主学习 将spring版本升级到spring 6.0.4,并且结合官方   
[文档](https://docs.spring.io/spring-framework/docs/current/reference/html/) 进行学习
jdk:17  
## 学习内容

1. [Spring 编程模块](/learn-spring-dependency/SpringProgramingModel.md)  
### **Ioc相关**
1. [Ioc 总览](/learn-ioc/doc/iocOverview.md)
2. [依赖查找以及依赖注入](/learn-ioc/doc/di_lookup.md)
3. [java bean的ioc支持](/learn-ioc/doc/iocJavaBean.md)
4. [Spring 与Ioc](/learn-ioc/doc/SpringWithIoC.md)
   1. [Spring依赖查找](/learn-ioc/doc/springioc/SpringDL.md)
      * [IOC依赖查找问题](/learn-ioc/doc/springioc/springDL/SpringDLQuestions.md)
   2. [Spring依赖注入](/learn-ioc/doc/springioc/SpringDI.md)
      * [自动装配](/learn-ioc/doc/springioc/springDI/autowired.md)
      * [依赖解决](/learn-ioc/doc/springioc/springDI/dependencyResolve.md)
      * [方法构造器注入](/learn-ioc/doc/springioc/springDI/setterAndConstructorDi.md)
      * [@Autowired原理](/learn-ioc/doc/springioc/springDI/%40Autowired.md)
      * [@Resource以及其他注解原理](/learn-ioc/doc/springioc/springDI/%40Resource.md)
      * [自定义注解注入](/learn-ioc/doc/springioc/springDI/customAnnotation.md)
      * [相关问题](/learn-ioc/doc/springioc/springDI/springDIQuestion.md)
   3. [依赖来源](/learn-ioc/doc/springioc/SpringDS.md)
   4. [IOC相关问题](/learn-ioc/doc/springioc/SpringIOCQuestions.md)
   

### **Spring Bean相关**
1. [Spring 与Beans](/learn-spring-beans/doc/SpringBeans.md)
   1. [Spring Bean的命名](/learn-spring-beans/doc/bean_lifecyle/SpringBeanNaming.md)
   2. [Spring bean的定义](/learn-spring-beans/doc/bean_lifecyle/SpringBeansDefinition.md)
   3. [Spring bean的创建](/learn-spring-beans/doc/bean_lifecyle/SpringBeansCreateAndRegister.md)
   4. [Spring bean的实例化](/learn-spring-beans/doc/bean_lifecyle/SpringBeansInstantiation.md)
   5. [Spring bean的销毁](/learn-spring-beans/doc/bean_lifecyle/SpringBeansDestory.md)
   6. [Spring单例Bean](/learn-spring-beans/doc/bean_lifecyle/SpringBeanSingleton.md)
   7. [非SpringBean](/learn-spring-beans/doc/bean_lifecyle/NoSpringBeanRegister.md)