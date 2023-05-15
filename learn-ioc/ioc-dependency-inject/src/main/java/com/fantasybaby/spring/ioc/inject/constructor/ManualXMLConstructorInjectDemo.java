package com.fantasybaby.spring.ioc.inject.constructor;

import com.fantasybaby.spring.ioc.inject.constructor.holder.UserHolder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 *  create by xml
 * Created on 5/11/2023.
 *
 * @author Fantasy Baby
 */
public class ManualXMLConstructorInjectDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        String contextPath = "classpath:/ioc-inject-constructor.xml";
        xmlBeanDefinitionReader.loadBeanDefinitions(contextPath);

        UserHolder bean = defaultListableBeanFactory.getBean(UserHolder.class);
        System.out.println(bean.getUser());
    }
}
