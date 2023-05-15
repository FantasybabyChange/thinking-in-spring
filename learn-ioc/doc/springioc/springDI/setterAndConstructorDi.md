## **依赖注入类型**
|类型| 使用场景|
|----|----|
|构造器注入| 低依赖|
|Setter 方法注入| 多依赖|
|字段注入| 便利性|
|方法注入| 声明类|

## **Set方法注入**
通过Set方法注入也分为手动和自动
### 1. **手动模式**
* 通过XML资源配置
* 通过注解配置元信息
* 通过API配置元信息
### 2. **自动模式**
* 通过byName
* 通过byType

## **构造器注入**
构造器注入是有序的
### **手动模式**
* 通过XML资源配置
* 通过注解配置元信息
* 通过API配置元信息
### **自动模式**
 * constructor


## **字段注入**
### **手动模式**
 Java 注解配置元信息
 * @Autowired
 * @Resource
 * @Inject（可选）

## **方法注入**
### **手动模式**
 Java 注解配置元信息
 * @Autowired
 * @Resource
 * @Inject（可选）
 * @Bean

## **接口回调注入**
### **Aware 系列接口回调**
[官方文档](https://docs.spring.io/spring-framework/reference/core/beans/factory-nature.html#aware-list)
|内建接口|解释 |
|-----|------ |
|BeanFactoryAware| 获取 IoC 容器 - BeanFactory|
|ApplicationContextAware| 获取 Spring 应用上下文 - ApplicationContext 对象|
|EnvironmentAware| 获取 Environment 对象|
|ResourceLoaderAware| 获取资源加载器 对象 - ResourceLoader|
|BeanClassLoaderAware| 获取加载当前 Bean Class 的 ClassLoader|
|BeanNameAware| 获取当前 Bean 的名|
|MessageSourceAware| 获取 MessageSource 对象，用于 Spring 国际化|
|ApplicationEventPublisherAware| 获取 ApplicationEventPublishAware 对象，用于 Spring 事件|
|EmbeddedValueResolverAware| 获取 StringValueResolver 对象，用于占位符处理|
