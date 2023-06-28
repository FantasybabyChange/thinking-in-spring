## **自动绑定**
### **简介**
[自动绑定概念](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-autowire)  
Spring容器可以在合作的Bean之间自动绑定关系. 可以通过检查 ApplicationContext的内容来让Spring决定合作的bean(其他bean).  
自动绑定的优势:
1. 自动绑定可以显著的减少需要指定的配置或者构造器参数.
2. 自动绑定可以通过对象的演变来更新配置. 举例来说:如果你需要给类添加依赖项,这个依赖可以不通过修改就能自动的满足.

### **自动绑定的模式**
具体参考[Autowire](https://github.com/spring-projects/spring-framework/blob/main/spring-beans/src/main/java/org/springframework/beans/factory/annotation/Autowire.java)
|模式| 解释|
|----|----|
| no | 默认的. 没有自动绑定.Bean的引用必须通过 ref元素定义. 不建议在大的项目中修改默认值, 因为明确指定可以更好有的控制度和清晰度|
| byName | 通过属性名称自动绑定. 如果一个Bean通过名称设置了自动绑定,就相当于有了一个set方法.   master -> setMaster() 通过这个方法设置属性|
| byType |通过属性类型来匹配容器里的Bean.如果大于一个Bean 则会抛出一个致命异常,如果没有匹配到Bean则什么都不会发生|
| constructor | 类似于byType,但是主要对于构造器参数.如果没有对应类型的参数在构造器中,则会抛出异常.|
### **自动绑定的限制** 
[官方文档](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-autowired-exceptions)  
自动绑定在整个项目中保持一致是最好的.如果自动绑定并不是普遍使用,只有一两个Bean自动绑定会让开发者感到困惑.下面是自动绑定的局  
1. **限性和缺点**:
   1. 在属性和构造器参数设置明确的依赖总是会覆盖自动绑定. 并且不能自动绑定原始属性,比如String,Class等(这事设计的局限性).
   2. 自动绑定对于精确指定少了精确性. Spring更加在意避免猜测,模棱两可. 用自动绑定的Bean不太好做文档维护.
   3. 自动绑定的信息不好使用工具从Spring容器中去产生文档,也很难用工具分析出问题.
   4. 如果又多个Bean定义,会与 setter和构造器的参数绑定.对于集合不是一个问题,但是对于单一的值,则会报错(no unique bean 的异常)  

2. **解决方法**
   1. 停止使用自动绑定而使用显示的绑定
   2. 通过将 autowire-candidate属性设置为false来避免自动绑定
   3. 使用primary来标注Bean
   4. 通过基于注解([@Autowired](%40Autowired.md) ..)实现更细粒度的控制
