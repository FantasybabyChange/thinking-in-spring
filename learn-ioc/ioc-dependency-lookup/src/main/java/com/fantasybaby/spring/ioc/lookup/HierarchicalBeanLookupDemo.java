package com.fantasybaby.spring.ioc.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 双亲委派BeanFactory查找
 * {@link org.springframework.beans.factory.HierarchicalBeanFactory}
 * {@link ConfigurableListableBeanFactory}
 * Created on 4/23/2023.
 *
 * @author Fantasy Baby
 */
public class HierarchicalBeanLookupDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(SingleBeanLookupDemo.class);
        // 获取 HierarchicalBeanFactory <- ConfigurableBeanFactory <- ConfigurableListableBeanFactory
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        ConfigurableListableBeanFactory parentBeanFactory = createParentBeanFactory();
        beanFactory.setParentBeanFactory(parentBeanFactory);


        displayContainsLocalBean(beanFactory,"user");
        displayContainsLocalBean(parentBeanFactory, "user");


        displayContainsBean(beanFactory,"user");
        displayContainsBean(parentBeanFactory,"user");
        applicationContext.refresh();

        applicationContext.close();
    }

    private static DefaultListableBeanFactory createParentBeanFactory() {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        String locations = "classpath:/study-ioc-lookup.xml";
        xmlBeanDefinitionReader.loadBeanDefinitions(locations);
        return defaultListableBeanFactory;
//        return new ClassPathXmlApplicationContext("classpath:/study-ioc-lookup.xml");
    }
    private static void displayContainsLocalBean(BeanFactory beanFactory, String beanName) {
        if(beanFactory instanceof HierarchicalBeanFactory){
            HierarchicalBeanFactory cast = HierarchicalBeanFactory.class.cast(beanFactory);
            System.out.printf("当前 HierarchicalBeanFactory[%s] 是否包含 Local Bean[name : %s] : %s\n", cast, beanName,
                    cast.containsLocalBean(beanName));
        }else{
            System.out.printf("当前 BeanFactory[%s] 是否包含  Bean[name : %s] : %s\n", beanFactory, beanName,
                    beanFactory.containsBean(beanName));
        }

    }

    private static void displayContainsBean(HierarchicalBeanFactory beanFactory, String beanName) {
        System.out.printf("当前 BeanFactory[%s] 是否包含 Bean[name : %s] : %s\n", beanFactory, beanName,
                containsBean(beanFactory, beanName));
    }

    /**
     * 使用递归查找bean
     *
     * @param beanFactory bean工厂
     * @param beanName    bean名字
     * @return boolean
     */
    private static boolean containsBean(HierarchicalBeanFactory beanFactory, String beanName) {
        BeanFactory parentBeanFactory = beanFactory.getParentBeanFactory();
        if (parentBeanFactory instanceof HierarchicalBeanFactory) {
            HierarchicalBeanFactory parentHierarchicalBeanFactory = HierarchicalBeanFactory.class.cast(parentBeanFactory);
            if (containsBean(parentHierarchicalBeanFactory, beanName)) {
                return true;
            }
        }
        return beanFactory.containsLocalBean(beanName);
    }
}
