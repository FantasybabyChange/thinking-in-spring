package com.fantasybaby.spring.ioc.overview.container;

import com.fantasybaby.spring.ioc.overview.model.User;
import com.fantasybaby.spring.ioc.overview.model.UserLook;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 *  使用 {@link DefaultListableBeanFactory} 作为容器查找bean
 * Created on 3/28/2023.
 *
 * @author Fantasy Baby
 */
public class BeanFactoryIocContainer {
    public static void main(String[] args) {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        String locations = "classpath:/study-ioc-lookup.xml";
        int loadBeanCount = xmlBeanDefinitionReader.loadBeanDefinitions(locations);
        System.out.println("loadBeanCount: " + loadBeanCount);
        Map<String, User> beansOfType = (Map) defaultListableBeanFactory.getBeansWithAnnotation(UserLook.class);
        System.out.println("通过BeanFactory和注解查找Bean" + beansOfType);
    }
}
