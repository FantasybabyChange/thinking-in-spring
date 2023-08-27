package com.fantasybaby.spring.ioc.source.di;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ResourceLoader;

/**
 * 依赖注入的依赖来源
 *
 * @author FantasyBaby
 * @date 2023/08/27
 */

public class DiDependencySourceDemo {
    @Inject
    BeanFactory beanFactory;
    @Inject
    ResourceLoader resourceLoader;
    @Inject
    ApplicationEventPublisher applicationEventPublisher;
    @Inject
    ApplicationContext applicationContext;

    /**
     * {@link  org.springframework.context.support.AbstractApplicationContext#prepareBeanFactory(ConfigurableListableBeanFactory)} 可以看到下面四个Bean的注入情况
     */
    @PostConstruct
    public void postInit() {
        System.out.println("beanFactory  resourceLoader " + (beanFactory == resourceLoader));
        System.out.println("resourceLoader applicationEventPublisher " + (applicationEventPublisher == resourceLoader));
        System.out.println("applicationEventPublisher applicationContext " + (applicationContext == resourceLoader));
        System.out.println("applicationContext resourceLoader " + (applicationContext == resourceLoader));


    }

    @PostConstruct
    public void getInjectBean() {
        getBean(BeanFactory.class);
        getBean(ResourceLoader.class);
        getBean(ApplicationEventPublisher.class);
        getBean(ApplicationContext.class);
    }

    public <T> void getBean(Class<T> beanType) {
        try {
            T bean = applicationContext.getBean(beanType);
        } catch (Exception e) {
            System.err.println("beanType:" + beanType + "不存在");
        }

    }

    public static <T> void getBean(ApplicationContext context, Class<T> beanType) {
        try {
            T bean = context.getBean(beanType);
        } catch (Exception e) {
            System.err.println("beanType:" + beanType + "不存在");
        }

    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(DiDependencySourceDemo.class);
        annotationConfigApplicationContext.refresh();
        getBean(annotationConfigApplicationContext, BeanFactory.class);
        getBean(annotationConfigApplicationContext, ResourceLoader.class);
        getBean(annotationConfigApplicationContext, ApplicationEventPublisher.class);
        getBean(annotationConfigApplicationContext, ApplicationContext.class);


    }
}
