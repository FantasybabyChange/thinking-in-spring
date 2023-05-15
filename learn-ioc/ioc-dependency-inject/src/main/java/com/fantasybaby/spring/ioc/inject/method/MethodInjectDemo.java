package com.fantasybaby.spring.ioc.inject.method;

import com.fantasybaby.spring.ioc.inject.method.holder.UserHolder;
import com.fantasybaby.spring.ioc.overview.model.User;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * method inject
 * Created on 5/11/2023.
 *
 * @author Fantasy Baby
 */
public class MethodInjectDemo {
    private UserHolder userHolder;

    private UserHolder userHolder2;


    private UserHolder userHolder3;

    @Bean
    public UserHolder userHolder(User user) {
        userHolder = new UserHolder(user
        );
        return userHolder;

    }

    @Autowired
    public void initUser2(UserHolder userHolder) {
        this.userHolder2 = userHolder;
    }

    @Resource
    public void initUser3(UserHolder userHolder) {
        this.userHolder3 = userHolder;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(MethodInjectDemo.class);
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(annotationConfigApplicationContext);
        String contextPath = "classpath:/study-ioc-lookup.xml";
        xmlBeanDefinitionReader.loadBeanDefinitions(contextPath);
        annotationConfigApplicationContext.refresh();
        MethodInjectDemo bean = annotationConfigApplicationContext.getBean(MethodInjectDemo.class);
        System.out.println(bean.userHolder.getUser());

        System.out.println(bean.userHolder == bean.userHolder2 );
        System.out.println(bean.userHolder2 == bean.userHolder3 );
    }


}
