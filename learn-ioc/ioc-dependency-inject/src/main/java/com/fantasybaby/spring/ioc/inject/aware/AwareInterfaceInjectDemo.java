package com.fantasybaby.spring.ioc.inject.aware;

import com.fantasybaby.spring.ioc.inject.aware.holder.UserHolder;
import com.fantasybaby.spring.ioc.overview.model.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * use {@link org.springframework.beans.factory.Aware} inject
 * Created on 5/11/2023.
 *
 * @author Fantasy Baby
 */
public class AwareInterfaceInjectDemo implements BeanFactoryAware, ApplicationContextAware {
    private BeanFactory beanFactory;
    private ApplicationContext applicationContext;


    @Bean
    public UserHolder userHolder(User user) {
        return new UserHolder(user
        );


    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(AwareInterfaceInjectDemo.class);
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(annotationConfigApplicationContext);
        String contextPath = "classpath:/study-ioc-lookup.xml";
        xmlBeanDefinitionReader.loadBeanDefinitions(contextPath);
        annotationConfigApplicationContext.refresh();
        AwareInterfaceInjectDemo injectDemo = annotationConfigApplicationContext.getBean(AwareInterfaceInjectDemo.class);
        System.out.println(annotationConfigApplicationContext == injectDemo.applicationContext);
        System.out.println(annotationConfigApplicationContext.getBeanFactory() == injectDemo.beanFactory);
        System.out.println(injectDemo.applicationContext.getBean(UserHolder.class).getUser());

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
