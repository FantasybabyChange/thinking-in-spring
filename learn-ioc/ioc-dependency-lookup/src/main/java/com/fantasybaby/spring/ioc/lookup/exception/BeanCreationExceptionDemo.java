package com.fantasybaby.spring.ioc.lookup.exception;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * {@link org.springframework.beans.factory.BeanCreationException}
 * Created on 5/8/2023.
 *
 * @author Fantasy Baby
 */
public class BeanCreationExceptionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(BeanCreationExceptionDemo.class);
        applicationContext.registerBean("exceptionBean", InnerBean.class);
        applicationContext.refresh();
        applicationContext.close();
    }

    static class InnerBean implements InitializingBean {
        @Override
        public void afterPropertiesSet() throws Exception {
            throw new RuntimeException("a exception");
        }
    }

}
