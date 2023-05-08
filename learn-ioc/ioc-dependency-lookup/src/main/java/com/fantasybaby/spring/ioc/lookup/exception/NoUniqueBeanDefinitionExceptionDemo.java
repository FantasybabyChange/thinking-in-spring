package com.fantasybaby.spring.ioc.lookup.exception;

import com.fantasybaby.spring.ioc.overview.model.User;
import com.fantasybaby.spring.ioc.overview.model.VipUser;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * {@link org.springframework.beans.factory.NoUniqueBeanDefinitionException}
 * Created on 5/8/2023.
 *
 * @author Fantasy Baby
 */
public class NoUniqueBeanDefinitionExceptionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(NoUniqueBeanDefinitionExceptionDemo.class);

        applicationContext.refresh();
        //
        Object noSuch = applicationContext.getBean(User.class);

        applicationContext.close();
    }

    @Bean
    public User user() {
        return new User();
    }

    @Bean
    public User vip() {
        return new VipUser();
    }
}
