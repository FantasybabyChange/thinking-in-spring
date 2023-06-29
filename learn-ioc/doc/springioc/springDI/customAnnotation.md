## **自定义注解注入**
[代码位置](../../../ioc-dependency-inject/src/main/java/com/fantasybaby/spring/ioc/inject/annotation/)  
### **实现方式**
#### 通过继承注解
Spring默认可以通过让自己的注解被@Autowired 标注就可以直接使用
#### 通过自定义BeanPostProcessor
  Spring的AutowiredAnnotationBeanPostProcessor提供了类似 setAutowiredAnnotationTypes等方法可以设置相关注解
 自定义实现
 生命周期处理
 InstantiationAwareBeanPostProcessor
 MergedBeanDefinitionPostProcessor
 元数据
 InjectedElement
 InjectionMetadata
