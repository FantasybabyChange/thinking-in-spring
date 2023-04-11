package com.fantasybaby.spring.beans.overview.instantiation;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 常规实例化Bean的方法
 * Created on 4/11/2023.
 * <ul>
 *     <li>静态方法</li>
 *     <li>实例方法</li>
 *     <li>通过FactoryBean</li>
 * </ul>>
 *
 * @author Fantasy Baby
 */
public class BeanInstantiationNormal {
    public static void main(String[] args) {
        ApplicationContext beanFactory = new ClassPathXmlApplicationContext("classpath:/normal-instantiation-bean.xml");
        Map<String, Music> beansOfType = beanFactory.getBeansOfType(Music.class);
        System.out.println(beansOfType);

    }
}
