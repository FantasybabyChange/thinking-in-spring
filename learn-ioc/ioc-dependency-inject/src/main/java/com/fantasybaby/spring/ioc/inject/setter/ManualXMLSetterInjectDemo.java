package com.fantasybaby.spring.ioc.inject.setter;

import com.fantasybaby.spring.ioc.inject.setter.holder.UserHolder;
import com.fantasybaby.spring.ioc.overview.model.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 *  create by xml
 * Created on 5/11/2023.
 *
 * @author Fantasy Baby
 */
public class ManualXMLSetterInjectDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        String contextPath = "classpath:/ioc-inject-setter.xml";
        xmlBeanDefinitionReader.loadBeanDefinitions(contextPath);

        UserHolder bean = defaultListableBeanFactory.getBean(UserHolder.class);
        System.out.println(bean.getUser());
    }
}
