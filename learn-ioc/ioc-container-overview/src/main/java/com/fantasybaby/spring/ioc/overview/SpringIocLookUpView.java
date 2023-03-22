package com.fantasybaby.spring.ioc.overview;

import com.fantasybaby.spring.ioc.overview.model.User;
import com.fantasybaby.spring.ioc.overview.model.UserLook;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 *  简单的看看依赖查找
 * Created on 3/22/2023.
 *
 * @author FantasyBaby
 */
public class SpringIocLookUpView {
    public static void main(String[] args) {
        /**
         * 通过xml配置文件获取Spring上下文
         */
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/study-ioc-lookup.xml");

        getBeanRealTime(beanFactory);

        lookupInLazy(beanFactory);

        getBeanByType(beanFactory);

        getCollectionBeans(beanFactory);

        getBeansByAnnotation(beanFactory);

    }

    /**
     * 通过注解查询bean
     *
     * @param beanFactory bean工厂
     */
    private static void getBeansByAnnotation(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beansOfType = (Map)listBeanFactory.getBeansWithAnnotation(UserLook.class);
            System.out.println("通过注解查找Bean" + beansOfType);
        }
    }

    /**
     * 查看集合bean
     *
     * @param beanFactory bean工厂
     */
    private static void getCollectionBeans(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beansOfType = listBeanFactory.getBeansOfType(User.class);
            System.out.println("查看所有的用户集合对象" + beansOfType);
        }
    }

    /**
     * 通过类型获取对象
     *
     * @param beanFactory bean工厂
     */
    private static void getBeanByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean("user", User.class);
        System.out.printf("通过类型获取" + user);
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
    private static void getBeanRealTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时查找" + user);
    }
}
