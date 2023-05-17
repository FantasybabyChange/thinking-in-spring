package com.fantasybaby.spring.ioc.inject.basetype;

import com.fantasybaby.spring.ioc.inject.setter.holder.UserHolder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * inject basic type
 * {@link Enum}
 * {@link org.springframework.core.io.Resource}
 * Created on 5/11/2023.
 *
 * @author Fantasy Baby
 */
public class BasicTypeInjectDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        String contextPath = "classpath:/ioc-inject-basic-type.xml";
        xmlBeanDefinitionReader.loadBeanDefinitions(contextPath);

        UserHolder bean = defaultListableBeanFactory.getBean(UserHolder.class);
        System.out.println(bean.getUser());
    }
}
