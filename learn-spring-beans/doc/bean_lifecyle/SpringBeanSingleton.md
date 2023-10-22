# **Spring Beans Singleton**
## **1. 单例对象依赖来源**
注入来源是: 外部普通 Java 对象（不一定是 POJO）
限制
   * 无生命周期管理
   * 无法实现延迟初始化 Bean

### **1.1 注册方法：**  
当前接口定义了单例对象的注册
[SingletonBeanRegistry]([SingletonBeanRegistry](https://github.com/spring-projects/spring-framework/blob/main/spring-beans/src/main/java/org/springframework/beans/factory/config/SingletonBeanRegistry.java) )#**registerSingleton**
```
void registerSingleton(String beanName, Object singletonObject);
```
默认实现为[DefaultSingletonBeanRegistry](https://github.com/spring-projects/spring-framework/blob/main/spring-beans/src/main/java/org/springframework/beans/factory/support/DefaultSingletonBeanRegistry.java)**#registerSingleton**.  
具体调用为DefaultListableBeanFactory->调用super.registerSingleton
```java
public void registerSingleton(String beanName, Object singletonObject) throws IllegalStateException {
		super.registerSingleton(beanName, singletonObject);
		updateManualSingletonNames(set -> set.add(beanName), set -> !this.beanDefinitionMap.containsKey(beanName));
		clearByTypeCache();
	}
```
下面为DefaultSingletonBeanRegistry的实现. 
1. `singletonObjects singletonFactories这个两个变量是互斥的`
2. `registeredSingletons`是一个 `LinkedHashSet`所以注册保证了有序
```java 
protected void addSingleton(String beanName, Object singletonObject) {
		synchronized (this.singletonObjects) {
			this.singletonObjects.put(beanName, singletonObject);
			this.singletonFactories.remove(beanName);
			this.earlySingletonObjects.remove(beanName);
			this.registeredSingletons.add(beanName);
		}
	}
```
在依赖查找中,如果使用beanName查找 也会先查看是否在single中
```java
protected <T> T doGetBean(
			String name, @Nullable Class<T> requiredType, @Nullable Object[] args, boolean typeCheckOnly)
			throws BeansException {
...
		Object sharedInstance = getSingleton(beanName);
...
         }
```
具体查询的逻辑
```java 
Object singletonObject = this.singletonObjects.get(beanName);
		if (singletonObject == null && isSingletonCurrentlyInCreation(beanName)) {
			singletonObject = this.earlySingletonObjects.get(beanName);
			if (singletonObject == null && allowEarlyReference) {
				synchronized (this.singletonObjects) {
					// Consistent creation of early reference within full singleton lock
					singletonObject = this.singletonObjects.get(beanName);
					if (singletonObject == null) {
						singletonObject = this.earlySingletonObjects.get(beanName);
						if (singletonObject == null) {
							ObjectFactory<?> singletonFactory = this.singletonFactories.get(beanName);
							if (singletonFactory != null) {
								singletonObject = singletonFactory.getObject();
								this.earlySingletonObjects.put(beanName, singletonObject);
								this.singletonFactories.remove(beanName);
							}
						}
					}
				}
			}
		}
```