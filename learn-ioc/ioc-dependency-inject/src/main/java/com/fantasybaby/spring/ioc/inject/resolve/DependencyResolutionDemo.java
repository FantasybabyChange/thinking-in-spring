package com.fantasybaby.spring.ioc.inject.resolve;

import com.fantasybaby.spring.ioc.overview.model.User;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

import java.util.List;
import java.util.Optional;

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
     *  primary = true;
     *   mapping {@link org.springframework.context.annotation.CommonAnnotationBeanPostProcessor}
     */
//    @Resource
    private User someUser;


    /**
     * {@link  org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor}
     */
    @Autowired
    private User autoUser;

    /**
     * lazy 对象的创建 会返回一个代理对象
     */
//    @Resource
//    @Lazy
//    private User someUserLazy;

    /**
     * 只注入一个Bean
     * 对应的 {@link DependencyDescriptor}
     * 	required = true;
     * 	eager = false;
     *  primary = true;
     *  type = util.List
     */
//    @Resource
//    private List<User> someUsers;
    /**
     * optional的对象创建
     */
//    @Resource
//    private Optional<User> someUserOptional;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(DependencyResolutionDemo.class);
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(annotationConfigApplicationContext);
        String contextPath = "classpath:/study-ioc-lookup.xml";
        xmlBeanDefinitionReader.loadBeanDefinitions(contextPath);
        annotationConfigApplicationContext.refresh();
//        System.out.println(annotationConfigApplicationContext.getBean(DependencyResolutionDemo.class).someUserOptional.get());
    }

}
