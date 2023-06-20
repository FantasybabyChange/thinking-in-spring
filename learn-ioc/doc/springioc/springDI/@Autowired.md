## **使用@Resource注入**
@Resource 是 java提供的一个注解 
```xml
  <dependency>
         <groupId>jakarta.annotation</groupId>
         <artifactId>jakarta.annotation-api</artifactId>
         <version>${jakarta.annotation.version}</version>
   </dependency>
```
### **@Autowired注入的规则以及原理**
@Autowired注解由这个类去筛选[AutowiredAnnotationBeanPostProcessor](https://github.com/spring-projects/spring-framework/blob/main/spring-beans/src/main/java/org/springframework/beans/factory/annotation/AutowiredAnnotationBeanPostProcessor.java)  
@Resource由 [CommonAnnotationBeanPostProcessor](https://github.com/spring-projects/spring-framework/blob/main/spring-context/src/main/java/org/springframework/context/annotation/CommonAnnotationBeanPostProcessor.java)

ResourceElement  LookupElement