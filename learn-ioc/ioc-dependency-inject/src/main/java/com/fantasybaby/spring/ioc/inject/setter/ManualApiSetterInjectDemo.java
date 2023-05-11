package com.fantasybaby.spring.ioc.inject.setter;

import com.fantasybaby.spring.ioc.inject.setter.holder.UserHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * create by api code
 * Created on 5/11/2023.
 *
 * @author Fantasy Baby
 */
public class ManualApiSetterInjectDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(ManualApiSetterInjectDemo.class);
        AbstractBeanDefinition beanDefinition = createBeanDefinition();
        annotationConfigApplicationContext.registerBeanDefinition("userHolder", beanDefinition);
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(annotationConfigApplicationContext);
        String contextPath = "classpath:/study-ioc-lookup.xml";
        xmlBeanDefinitionReader.loadBeanDefinitions(contextPath);
        annotationConfigApplicationContext.refresh();
        UserHolder bean = annotationConfigApplicationContext.getBean(UserHolder.class);
        System.out.println(bean.getUser());
    }

    private static AbstractBeanDefinition createBeanDefinition() {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
        beanDefinitionBuilder.addPropertyReference("user", "user2");
        return beanDefinitionBuilder.getBeanDefinition();
    }


}
