package com.fantasybaby.spring.ioc.inject.field;

import com.fantasybaby.spring.ioc.inject.field.holder.UserHolder;
import com.fantasybaby.spring.ioc.overview.model.User;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * filed autowired
 * Created on 5/11/2023.
 *
 * @author Fantasy Baby
 */
public class FiledInjectDemo {
    @Resource
    private UserHolder userHolder;

    @Autowired
    private UserHolder userHolder2;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(FiledInjectDemo.class);
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(annotationConfigApplicationContext);
        String contextPath = "classpath:/study-ioc-lookup.xml";
        xmlBeanDefinitionReader.loadBeanDefinitions(contextPath);
        annotationConfigApplicationContext.refresh();
        FiledInjectDemo bean = annotationConfigApplicationContext.getBean(FiledInjectDemo.class);
        System.out.println(bean.userHolder.getUser());

        System.out.println(bean.userHolder == bean.userHolder2);
    }

    @Bean
    public UserHolder userHolder(User user) {
        return new UserHolder(user);
    }
}
