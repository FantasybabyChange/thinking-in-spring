package com.fantasybaby.spring.ioc.overview;

import com.fantasybaby.spring.ioc.overview.model.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created on 3/22/2023.
 *
 * @author FantasyBaby
 */
public class SpringIocLookUp {
    public static void main(String[] args) {
        /**
         * 通过xml配置文件获取Spring上下文
         */
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/study-ioc.xml");
        getBeanById(beanFactory);
        lookupInLazy(beanFactory);
    }

    private static void lookupInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延时查找" + user);
    }

    /**
     * 通过 bean id 或者name 实时获取对应的bean
     * 有name则用name 没有name看id 如果两者都有会按照顺序匹配 匹配到就返回
     *
     * @param beanFactory bean工厂
     */
    private static void getBeanById(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时查找" + user);
    }
}
