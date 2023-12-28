package com.fantasybaby.spring.ioc.source.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

/**
 * 外部化配置依赖来源
 *
 * @author FantasyBaby
 * @date 2023/12/28
 */
@Configuration
@PropertySource(value = "external.properties", encoding = "UTF-8")
public class ExternalConfigurationDependencySourceDemo {
    /**
     * 系统用户优先级高
     */
    @Value("${user.name}")
    private String name;

    @Value("${user.name1}")
    private String name1;
    @Value("${user.id}")
    private Long id;
    @Value("${user.resource}")
    private Resource resource;


    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(ExternalConfigurationDependencySourceDemo.class);
        annotationConfigApplicationContext.refresh();

        ExternalConfigurationDependencySourceDemo bean = annotationConfigApplicationContext.getBean(ExternalConfigurationDependencySourceDemo.class);

        System.out.println("name:" + bean.name);
        /**
         * 不指定编码会乱码
         */
        System.out.println("name1:" + bean.name1);
        System.out.println("id:" + bean.id);
        System.out.println("resource:" + bean.resource);


    }
}
