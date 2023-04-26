package com.fantasybaby.spring.ioc.lookup;

import com.fantasybaby.spring.ioc.overview.model.User;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.function.Consumer;

/**
 * 双亲委派BeanFactory查找
 * {@link HierarchicalBeanFactory}
 * {@link ConfigurableListableBeanFactory}
 * Created on 4/23/2023.
 *
 * @author Fantasy Baby
 */
public class TypeSafeLookupDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(SingleBeanLookupDemo.class);
        applicationContext.refresh();


        displayBeanFactorySafety(applicationContext);

        displayObjectFactorySafety(applicationContext.getBeanProvider(User.class));

        displayObjectFactoryProviderSafety(applicationContext.getBeanProvider(User.class));

        displayObjectFactoryProviderSafety(applicationContext.getBeanProvider(User.class));

        displayListableBeanFactorySafety(applicationContext);

        applicationContext.close();
    }

    /**
     * beanFactory 类型不安全
     *
     * @param beanFactory bean工厂
     */
    public static void displayBeanFactorySafety(BeanFactory beanFactory) {
        printException("displayBeanFactorySafety", it -> {
            User user = beanFactory.getBean(User.class);
            System.err.println(user);
        });
    }

    public static void displayObjectFactorySafety(ObjectFactory<User> beanFactory) {
        printException("displayObjectFactorySafety", it -> {
            User user = beanFactory.getObject();
            System.err.println(user);
        });
    }

    public static void displayObjectFactoryProviderSafety(ObjectProvider<User> beanFactory) {
        printException("displayObjectFactoryProviderSafety", it -> {
            User user = beanFactory.getIfAvailable();
            System.err.println(user);
        });
    }


    public static void displayListableBeanFactorySafety(ListableBeanFactory listableBeanFactory) {
        printException("displayListableBeanFactorySafety", it -> {
            Map<String, User> beansOfType = listableBeanFactory.getBeansOfType(User.class);
            System.err.println(beansOfType);
        });
    }
    public static void displayObjectProviderListSafety(ObjectProvider<User> objectProvider) {
        printException("displayObjectProviderListSafety", it -> {
            objectProvider.forEach(System.err::println);
        });
    }

    private static void printException(String name, Consumer<String> function) {
        try {
            System.err.println(name + "  print exception =============================");
            function.accept(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
