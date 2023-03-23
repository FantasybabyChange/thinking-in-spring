package com.fantasybaby.spring.ioc.overview;

import com.fantasybaby.spring.ioc.overview.model.User;
import com.fantasybaby.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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


        System.out.println(beanFactory);

        System.out.println(userRepository.getBeanFactory());
        /**
         * 依赖注入和依赖查找的bean不相同
         */
        System.out.println("beanFactory== user.beanFactory " + (beanFactory == userRepository.getBeanFactory()));

        ObjectFactory<User> userFactory = userRepository.getUser1ObjectFactory();
        System.out.println(userFactory.getObject());

        System.out.println("beanFactory和注入的context 是否相等 "+(userRepository.getApplicationContextObjectFactory().getObject() == beanFactory));

    }

}
