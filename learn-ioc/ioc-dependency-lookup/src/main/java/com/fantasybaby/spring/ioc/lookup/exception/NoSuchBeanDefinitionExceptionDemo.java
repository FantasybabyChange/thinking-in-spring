package com.fantasybaby.spring.ioc.lookup.exception;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * {@link org.springframework.beans.factory.NoSuchBeanDefinitionException}
 * Created on 5/8/2023.
 *
 * @author Fantasy Baby
 */
public class NoSuchBeanDefinitionExceptionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(NoSuchBeanDefinitionExceptionDemo.class);

        applicationContext.refresh();
        //
        Object noSuch = applicationContext.getBean("noSuch");

        applicationContext.close();
    }
}
