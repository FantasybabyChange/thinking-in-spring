## **ApplicationContext作为IOC容器**
### 容器生命周期
### **启动**  
![流程图](../pics/svg/APPLICAIONCONTEXT-START-WORKFLOW.svg)

### **运行**
### **停止**
```java
	public void close() {
		synchronized (this.startupShutdownMonitor) {
			doClose();
			// If we registered a JVM shutdown hook, we don't need it anymore now:
			// We've already explicitly closed the context.
			if (this.shutdownHook != null) {
				try {
					Runtime.getRuntime().removeShutdownHook(this.shutdownHook);
				}
				catch (IllegalStateException ex) {
					// ignore - VM is already shutting down
				}
			}
		}
	}
```