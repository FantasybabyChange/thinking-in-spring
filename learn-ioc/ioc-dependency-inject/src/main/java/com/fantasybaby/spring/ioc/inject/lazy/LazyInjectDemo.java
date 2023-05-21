package com.fantasybaby.spring.ioc.inject.lazy;

import com.fantasybaby.spring.ioc.inject.selection.CustomerAnnotationNameInjectDemo;
import com.fantasybaby.spring.ioc.inject.selection.FantasyGroup;
import com.fantasybaby.spring.ioc.overview.model.User;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * lazy inject
 * {@link ObjectProvider}
 * {@link ObjectFactory}
 * {@link org.springframework.core.io.Resource}
 * Created on 5/11/2023.
 *
 * @author Fantasy Baby
 */
public class LazyInjectDemo {
    @Resource
    @Qualifier("user1")
    private User someUser;
    @Resource
    private ObjectProvider<User> userObjectProvider;
    @Resource
    private ObjectFactory<List<User>> usersObjectFactory;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(LazyInjectDemo.class);
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(annotationConfigApplicationContext);
        String contextPath = "classpath:/study-ioc-lookup.xml";
        xmlBeanDefinitionReader.loadBeanDefinitions(contextPath);
        annotationConfigApplicationContext.refresh();


        LazyInjectDemo bean = annotationConfigApplicationContext.getBean(LazyInjectDemo.class);
        ObjectProvider<User> provider = bean.userObjectProvider;
        ObjectFactory<List<User>> factory = bean.usersObjectFactory;

        System.out.println("provider get Object " + provider.getObject());
        System.out.println("print provider");
        provider.forEach(System.out::println);
        System.out.println("print factory");
        factory.getObject().forEach(System.out::println);
    }

    @Bean
    public  User user4() {
        User user = new User();
        user.setName("groupUser1");
        return user;
    }

    @Bean
    public  User user5() {
        User user = new User();
        user.setName("groupUser2");
        return user;
    }
}
