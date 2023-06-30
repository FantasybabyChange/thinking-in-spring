## **自定义注解注入**
[代码位置](../../../ioc-dependency-inject/src/main/java/com/fantasybaby/spring/ioc/inject/annotation/)  
### **实现方式**
#### **通过继承注解**
Spring默认可以通过让自己的注解被@Autowired 标注就可以直接使用
#### **通过自定义BeanPostProcessor**

```java
  @Bean(name = AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME)
    public static AutowiredAnnotationBeanPostProcessor beanPostProcessor() {
        AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
        autowiredAnnotationBeanPostProcessor.setOrder(Ordered.LOWEST_PRECEDENCE - 10);
        LinkedHashSet<Class<? extends Annotation>> sets = new LinkedHashSet<>();
        sets.add(UserInject.class);
        sets.add(Autowired.class);
        autowiredAnnotationBeanPostProcessor.setAutowiredAnnotationTypes(sets);
        return autowiredAnnotationBeanPostProcessor;
    }
```
1. 通过覆盖AnnotationConfigUtils的AutowiredAnnotationBeanPostProcessor注入(可以共存)
2. 设置当前的枚举类型
  Spring的提供了类似 setAutowiredAnnotationTypes等方法可以设置相关注解

