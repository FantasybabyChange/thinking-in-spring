package com.fantasybaby.spring.ioc.inject.constructor;

import com.fantasybaby.spring.ioc.inject.constructor.holder.UserHolder;
import com.fantasybaby.spring.ioc.overview.model.User;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 *  create by java code
 * Created on 5/11/2023.
 *
 * @author Fantasy Baby
 */
public class ManualJavaConstructorInjectDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(ManualJavaConstructorInjectDemo.class);
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(annotationConfigApplicationContext);
        String contextPath = "classpath:/study-ioc-lookup.xml";
        xmlBeanDefinitionReader.loadBeanDefinitions(contextPath);
        annotationConfigApplicationContext.refresh();
        UserHolder bean = annotationConfigApplicationContext.getBean(UserHolder.class);
        System.out.println(bean.getUser());
    }

    @Bean
    public UserHolder userHolder(User user) {
        return new UserHolder(user);
    }
}
