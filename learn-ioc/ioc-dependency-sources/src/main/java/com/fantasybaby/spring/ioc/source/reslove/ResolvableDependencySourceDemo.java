package com.fantasybaby.spring.ioc.source.reslove;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * resolvable dependency 的依赖来源
 *
 * @author FantasyBaby
 * @date 2024/01/31
 */

public class ResolvableDependencySourceDemo {
    /**
     * 依赖注入无法被 依赖查找到
     */
    @Resource
    private String strValue;

    @PostConstruct
    public void init() {
        System.out.println("value:" + strValue);
    }
//    @Bean("strValue")
//    public String registerStrValue(){
//        return "A股SB";
//    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.register(ResolvableDependencySourceDemo.class);
        //通过回调注册则没有问题
        annotationConfigApplicationContext.addBeanFactoryPostProcessor(it-> it.registerResolvableDependency(String.class, "A股SB"));
        annotationConfigApplicationContext.refresh();

        AutowireCapableBeanFactory autowireCapableBeanFactory = annotationConfigApplicationContext.getAutowireCapableBeanFactory();

//        如此设置依赖注入无法获取String 因为refresh之后才注入的String 所以拿不到
//        if (autowireCapableBeanFactory instanceof ConfigurableListableBeanFactory) {
//            ConfigurableListableBeanFactory cast = (ConfigurableListableBeanFactory) autowireCapableBeanFactory;
//            cast.registerResolvableDependency(String.class, "A股SB");
//        }

        annotationConfigApplicationContext.close();
    }
}
