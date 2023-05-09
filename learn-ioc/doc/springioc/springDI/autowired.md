## **Autowired 自动绑定**
### **简介**
Autowired[官方文档](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-autowired-annotation)  
Spring容器可以在合作的Bean之间自动绑定关系. 可以通过检查 ApplicationContext的内容来让Spring决定合作的bean(其他bean).  
自动绑定的优势:
1. 自动绑定可以显著的减少需要指定的配置或者构造器参数.
2. 自动绑定可以通过对象的演变来更新配置. 举例来说:如果你需要给类添加依赖项,这个依赖可以不通过修改就能自动的满足.

