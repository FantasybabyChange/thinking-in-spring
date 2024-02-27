## prototype bean scope
非单例原型作用域,每次请求都会创建一个新的bean实例.无论依赖查找还是依赖注入
![原型作用域示意图](https://docs.spring.io/spring-framework/reference/_images/prototype.png)

### PrototypeBean 生命周期
 Spring无法完全管理prototypeBean的生命周期, 也不能够记录实例是否存在,只能通过BeanPostProcessor进行请扫工作.