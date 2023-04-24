package com.fantasybaby.spring.ioc.lookup;

import com.fantasybaby.spring.beans.overview.instantiation.Music;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * 单一类型 延迟查找
 * Created on 4/20/2023.
 *
 * @author Fantasy Baby
 */
public class SingleBeanLookupDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(SingleBeanLookupDemo.class);
        applicationContext.refresh();
        getBeanByObjectProvider(applicationContext);

        getBeanAvailable(applicationContext);

        getBeanByLambadaStream(applicationContext);

        applicationContext.close();
    }

    private static void getBeanByLambadaStream(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> beanProvider = applicationContext.getBeanProvider(String.class);
        beanProvider.forEach(System.out::println);
    }

    /**
     * 获取bean 不存在就创建
     *
     * @param applicationContext 应用程序上下文
     */
    private static void getBeanAvailable(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<Music> beanProvider = applicationContext.getBeanProvider(Music.class);
        Music ifAvailable = beanProvider.getIfAvailable(Music::createMusic);
        System.out.println(ifAvailable);
    }

    /**
     * 使用BeanProvider 来查找bean
     * @since spring5.1
     * @param applicationContext 应用程序上下文
     */
    private static void getBeanByObjectProvider(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> beanProvider = applicationContext.getBeanProvider(String.class);
        System.out.println(beanProvider.getObject());
        System.out.println(applicationContext.getBean("strMethodName"));
    }

    /**
     * 如果没有指定名称  beanName = "strMethodName"
     *
     * @return {@link String}
     */
    @Bean
    @Primary
    public String strMethodName() {
        return "abc";
    }

    @Bean
    public String strMethodName2() {
        return "cba";
    }
}
