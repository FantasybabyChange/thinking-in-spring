package com.fantasybaby.spring.ioc.lookup;

import jdk.jfr.Name;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 单一类型 延迟查找
 * Created on 4/20/2023.
 *
 * @author Fantasy Baby
 */
public class SingleBeanLookupDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(SingleBeanLookupDemo.class);
        applicationContext.refresh();
        getBeanByObjectProvider(applicationContext);
        applicationContext.close();
    }

    /**
     * 使用BeanProvider 来查找bean
     * @since spring5.1
     * @param applicationContext 应用程序上下文
     */
    private static void getBeanByObjectProvider(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> beanProvider = applicationContext.getBeanProvider(String.class);
        System.out.println(beanProvider.getObject());
        System.out.println(applicationContext.getBean("strMethodName"));
    }

    /**
     * 如果没有指定名称  beanName = "strMethodName"
     *
     * @return {@link String}
     */
    @Bean
    public String strMethodName() {
        return "abc";
    }
}
