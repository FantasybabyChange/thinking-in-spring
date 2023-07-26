## **依赖查找相关问题**
### **1. ObjectFactory BeanFactory的区别**
  ObjectFactory 和 BeanFactory均提供依赖查找的能力.  
* ObjectFactory仅关注一个或者一种类型的Bean 依赖查找,并且自身不具备依赖查找的能力,能力则由BeanFactory输出.  
* BeanFactory则提供了单一类型,集合类型以及层次性等多种依赖查找方式.

### **2.BeanFactory.getBean 操作是否线程安全？**
使用了ConcurrentHashMap 所以取得时候线程安全,但是在存储和删除的时候用锁控制.
org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#doCreateBean
```java
synchronized (mbd.postProcessingLock) {
			if (!mbd.postProcessed) {
				try {
					applyMergedBeanDefinitionPostProcessors(mbd, beanType, beanName);
				}
				catch (Throwable ex) {
					throw new BeanCreationException(mbd.getResourceDescription(), beanName,
							"Post-processing of merged bean definition failed", ex);
				}
				mbd.markAsPostProcessed();
			}
		}
```

### **3.Spring 查找与注入在来源上的区别**