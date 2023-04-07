package com.fantasybaby.spring.beans.overview;

import com.fantasybaby.spring.ioc.overview.model.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * use alias get bean
 * Created on 4/4/2023.
 *
 * @author Fantasy Baby
 */
public class BeanAliasDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/study-bean-alias.xml");
        User aliasBean = (User) beanFactory.getBean("system1-bean");
        User aliasBean2 = (User) beanFactory.getBean("system2-bean");
        User idBean = (User) beanFactory.getBean("user");
        //别名和原来的bean 相同
        System.out.println("alias with origin bean " + (aliasBean == idBean));
        System.out.println("alias1 with alias2 bean " + (aliasBean == aliasBean2));

    }
}
