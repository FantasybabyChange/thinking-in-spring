package com.fantasybaby.spring.ioc.overview;

import com.fantasybaby.spring.ioc.overview.model.User;
import com.fantasybaby.spring.ioc.overview.model.UserLook;
import com.fantasybaby.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 简单看看依赖注入
 * Created on 3/22/2023.
 *
 * @author FantasyBaby
 */
public class SpringIocDiView {
    public static void main(String[] args) {
        /**
         * 通过xml配置文件获取Spring上下文
         */
        var beanFactory = new ClassPathXmlApplicationContext("classpath:/study-ioc-di.xml");

        UserRepository userRepository = (UserRepository) beanFactory.getBean("userRepository");
        beanFactory.getBean("userRepository");
        System.out.println("获取注入的User" + userRepository.getUsers());


        System.out.println("beanFactory== user.beanFactory" + (beanFactory == userRepository.getBeanFactory()));

    }

}
