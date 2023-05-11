package com.fantasybaby.spring.ioc.inject.setter;

import com.fantasybaby.spring.ioc.inject.setter.holder.UserHolder;
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
public class ManualJavaSetterInjectDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(ManualJavaSetterInjectDemo.class);
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(annotationConfigApplicationContext);
        String contextPath = "classpath:/study-ioc-lookup.xml";
        xmlBeanDefinitionReader.loadBeanDefinitions(contextPath);
        annotationConfigApplicationContext.refresh();
        UserHolder bean = annotationConfigApplicationContext.getBean(UserHolder.class);
        System.out.println(bean.getUser());
    }

    @Bean
    public UserHolder userHolder(User user) {
        UserHolder userHolder = new UserHolder();
        userHolder.setUser(user);
        return userHolder;
    }
}
