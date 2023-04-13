# **Spring Beans Initialization**
## **Spring bean的初始化方式**  
* @PostConstruct 标注方法  
  ` 需要注意的是java9以后该注解已经从jdk rt.jar下移除` [相关资料](https://openjdk.org/jeps/320)
  ```xml
    <dependency>
        <groupId>javax.annotation</groupId>
        <artifactId>javax.annotation-api</artifactId>
        <version>${javax.annotation.version}</version>
    </dependency>
  ```
* 实现 InitializingBean 接口的 afterPropertiesSet() 方法
* 自定义初始化方法
  1. XML 配置：<bean init-method=”init” ... />
  2. Java 注解：@Bean(initMethod=”init”)
  3. Java API：AbstractBeanDefinition#setInitMethodName(String)   该方法无论是xml配置init-method还是 @Bean中指定都会进入该方法
   `该方法Spring 5.1以后移动到BeanDefinition中` 
   ```java
    /**
	 * Set the name of the initializer method.
	 * @since 5.1
	 */
	void setInitMethodName(@Nullable String initMethodName);
   ```
调用顺序为 @PostConstruct  -> InitializingBean ->  init-method
```
    DefaultMusicFactory start init method
    DefaultMusicFactory afterPropertiesSet
    DefaultMusicFactory start customerInitMethod init method
    after context refresh
```
### **bean的延时初始化方式**
* Bean 延迟初始化（Lazy Initialization）
* XML 配置：<bean lazy-init=”true” ... />
* Java 注解：@Lazy(true)
    ```当某个 Bean 定义为延迟初始化，那么，Spring 容器返回的对象与非延迟的对象存在怎样的差异？
    使用@Lazy后 初始化在context refresh之后
    ```


       