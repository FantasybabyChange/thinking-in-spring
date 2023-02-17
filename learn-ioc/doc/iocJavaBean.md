## **Java Beans作为Ioc容器**
使用Java Beans作为Ioc容器  
支持的特性  
 * 依赖查找
 * 生命周期管理
 * 配置元信息
 * 事件
 * 自定义
 * 资源管理
 * 持久化  
**相关规范**  
[JavaBeans](https://www.oracle.com/technetwork/java/javase/tech/index-jsp-138795.html)  
[BeanContext](https://docs.oracle.com/javase/8/docs/technotes/guides/beans/spec/beancontext.html)

**Introspector** 通过 **getBeanInfo** 方法获取Bean的信息
**PropertyDescriptor** 通过 **setPropertyEditorClass** 设置类型转换的类
```java
    BeanInfo beanInfo = Introspector.getBeanInfo(PersonPojo.class,Object.class);

     Stream.of(beanInfo.getPropertyDescriptors()).forEach(it-> {
            Class<?> propertyType = it.getPropertyType();
            String name = it.getName();
            if("age".equals(name)){
                
                it.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
//                it.createPropertyEditor()
            }
        });
    
     class StringToIntegerPropertyEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            Integer.valueOf(text);
            setValue(text);
        }
    }
```