## prototype bean scope
非单例原型作用域,每次请求都会创建一个新的bean实例.无论依赖查找还是依赖注入
![原型作用域示意图](https://docs.spring.io/spring-framework/reference/_images/prototype.png)

### PrototypeBean 生命周期

#### prototypeBean的 destory方式
 1. Spring无法完全管理prototypeBean的生命周期, 也不能够记录实例是否存在,只能通过BeanPostProcessor进行请扫工作.
```java
        annotationConfigApplicationContext.addBeanFactoryPostProcessor(beanFactory -> {
            // do something
            beanFactory.addBeanPostProcessor((new BeanPostProcessor() {
                @Override
                public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                    System.out.printf("beanName %s  after initial", beanName);
                    return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
                }
            }));
        });
```
 2. 建议手动调用destory方法
 比如 实现 DisposableBean 的destory() 然后手动调用对应bean的destory
 ```java
     @Override
    public void destroy() throws Exception {
        // 手动调用destory方法
        musicDo1.preDestroy();
        musicDos.forEach(MusicDo::preDestroy);
        for (Map.Entry<String, MusicDo> entry : musicDoMap.entrySet()) {
            String key = entry.getKey();
            if (beanFactory.isPrototype(key)) {
                entry.getValue().preDestroy();
            }
        }
    }
 ```