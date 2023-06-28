## **使用@Resource和其他通用注入**
@Resource 是 java提供的一个注解 
```xml
// JSR250
  <dependency>
         <groupId>jakarta.annotation</groupId>
         <artifactId>jakarta.annotation-api</artifactId>
         <version>${jakarta.annotation.version}</version>
   </dependency>
   // JSR330
    <dependency>
        <groupId>jakarta.inject</groupId>
        <artifactId>jakarta.inject-api</artifactId>
        <version>2.0.1</version>
    </dependency>

```
### **@Resource注入的规则以及原理**
和 @Autowired不同 @Resource是通过 [CommonAnnotationBeanPostProcessor](https://github.com/spring-projects/spring-framework/blob/main/spring-context/src/main/java/org/springframework/context/annotation/CommonAnnotationBeanPostProcessor.java)处理

#### CommonAnnotationBeanPostProcessor
**注入注解**
* ~~javax.xml.ws.WebServiceRef~~（新版本已经淘汰）
* javax.ejb.EJB
* javax.annotation.Resource | jakarta.annotation.Resource  

**生命周期注解**
* javax.annotation.PostConstruct | jakarta.annotation.PostConstruct
* javax.annotation.PreDestroy | jakarta.annotation.PreDestroy
CommonAnnotationBeanPostProcessor 的实现和AutowiredAnnotationBeanPostProcessor 类似

LifecycleElement
ResourceElement  LookupElement