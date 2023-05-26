package com.fantasybaby.spring.ioc.inject.resolve;

import com.fantasybaby.spring.ioc.overview.model.User;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * dependency resolution
 * {@link org.springframework.beans.factory.config.AutowireCapableBeanFactory#resolveDependency(DependencyDescriptor, String)}
 * {@link org.springframework.beans.factory.support.DefaultListableBeanFactory#resolveDependency(DependencyDescriptor, String)}
 * <p>
 * use source code to understand how dependency be resolved
 * Created on 5/11/2023.
 *
 * @author Fantasy Baby
 */
public class DependencyResolutionDemo {
    /**
     * 只注入一个Bean
     * 对应的 {@link DependencyDescriptor}
     * 	required = true;
     * 	eager = false;
     *
     */
    @Resource
    private User someUser;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(DependencyResolutionDemo.class);
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(annotationConfigApplicationContext);
        String contextPath = "classpath:/study-ioc-lookup.xml";
        xmlBeanDefinitionReader.loadBeanDefinitions(contextPath);
        annotationConfigApplicationContext.refresh();
    }

}
