## Spring Bean作用域

### 作用域分类依据区别
|来源|区别|
|--|--|
|singleton|默认 Spring Bean 作用域，一个 BeanFactory 有且仅有一个实例|
|prototype|原型作用域，每次依赖查找和依赖注入生成新 Bean 对象|
|request|将 Spring Bean 存储在 ServletRequest 上下文|
|session|将 Spring Bean 存储在 HttpSession 中|
|application|将 Spring Bean 存储在 ServletContext|
其中 request session application 主要在Web中使用


### singleton Bean作用域
[singleton bean scope](./singletonBeanScope.md) 相关介绍

### prototype Bean作用域
[prototype bean scope](./prototypeBeanScope.md) 相关介绍

### request Bean作用域

### session Bean作用域

### application Bean作用域