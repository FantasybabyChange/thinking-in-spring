package com.fantasybaby.spring.ioc.inject.annotation;

import com.fantasybaby.spring.ioc.overview.model.User;
import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;

import java.lang.annotation.Annotation;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;

import static org.springframework.context.annotation.AnnotationConfigUtils.AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME;

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
     * {@link  org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor}
     */
    @Autowired
    private User autoUser;

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
     * JSR 303
     * 注入用户
     */
    @Inject
    private List<User> injectUsers;

    @CAutowired
    private List<User> cAutowiredUser;
    /**
     * optional的对象创建
     */
    @UserInject
    private Optional<User> userInjectOptional;

    /**
     * 这里使用static 提前加载
     * <p>
     * {@link  org.springframework.context.annotation.AnnotationConfigUtils.AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME} 用来替换相同的bean名称
     *
     * @return {@link AutowiredAnnotationBeanPostProcessor}
     */
    @Bean(name = AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME)
    public static AutowiredAnnotationBeanPostProcessor beanPostProcessor() {
        AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
        autowiredAnnotationBeanPostProcessor.setOrder(Ordered.LOWEST_PRECEDENCE - 10);
        LinkedHashSet<Class<? extends Annotation>> sets = new LinkedHashSet<>();
        sets.add(UserInject.class);
        sets.add(Autowired.class);
        autowiredAnnotationBeanPostProcessor.setAutowiredAnnotationTypes(sets);
        return autowiredAnnotationBeanPostProcessor;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(InjectWithCustomAnnotationDemo.class);
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(annotationConfigApplicationContext);
        String contextPath = "classpath:/study-ioc-lookup.xml";
        xmlBeanDefinitionReader.loadBeanDefinitions(contextPath);
        annotationConfigApplicationContext.refresh();
        InjectWithCustomAnnotationDemo bean = annotationConfigApplicationContext.getBean(InjectWithCustomAnnotationDemo.class);
        System.out.println("userInject " + bean.userInjectOptional.orElseGet(null));
        System.out.println("inject " + bean.injectUsers);
        System.out.println("resource User " + bean.someUsers);
        System.out.println("cAutowiredUser User " + bean.cAutowiredUser);
        System.out.println("autowiredUser User " + bean.autoUser);
    }

}
