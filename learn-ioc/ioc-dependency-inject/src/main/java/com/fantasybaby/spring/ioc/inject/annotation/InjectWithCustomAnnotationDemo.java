package com.fantasybaby.spring.ioc.inject.annotation;

import com.fantasybaby.spring.ioc.overview.model.User;
import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Lazy;

import java.util.List;
import java.util.Optional;

/**
 * use custom annotation to inject dependency
 * <p>
 * {@link org.springframework.core.annotation.AnnotationUtils}
 *
 * @author Fantasy Baby
 * @date 2023/06/29
 */
public class InjectWithCustomAnnotationDemo {
    /**
     * 只注入一个Bean
     * 对应的 {@link DependencyDescriptor}
     * required = true;
     * eager = false;
     * primary = true;
     * mapping {@link org.springframework.context.annotation.CommonAnnotationBeanPostProcessor}
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
    @Resource
    @Lazy
    private User someUserLazy;

    /**
     * 只注入一个Bean
     * 对应的 {@link DependencyDescriptor}
     * required = true;
     * eager = false;
     * primary = true;
     * type = util.List
     */
    @Resource
    private List<User> someUsers;

    /**
     *  JSR 303
     * 注入用户
     */
    @Inject
    private List<User> injectUsers;
    /**
     * optional的对象创建
     */
    @CAutowired
    private Optional<User> someUserOptional;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(InjectWithCustomAnnotationDemo.class);
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(annotationConfigApplicationContext);
        String contextPath = "classpath:/study-ioc-lookup.xml";
        xmlBeanDefinitionReader.loadBeanDefinitions(contextPath);
        annotationConfigApplicationContext.refresh();
        System.out.println(annotationConfigApplicationContext.getBean(InjectWithCustomAnnotationDemo.class).someUserOptional.get());
    }

}
