## **使用@Autowired注入**
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
ResourceElement  LookupElement