package com.fantasybaby.spring.beans.overview;

import com.fantasybaby.spring.ioc.overview.model.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * build BeanDefinition
 * Created on 4/4/2023.
 *
 * @author Fantasy Baby
 */
public class BeanDefinitionBuildDemo {
    public static void main(String[] args) {
        createBeanDefinitionByBuilder();

        createUseDirectBeanDefinition();
    }

    /**
     * 通过 beanDefinition直接创建
     */
    private static void createUseDirectBeanDefinition() {
        GenericBeanDefinition userBeanDefinition = new GenericBeanDefinition();
        userBeanDefinition.setBeanClass(User.class);
        //设置属性值
        MutablePropertyValues values = new MutablePropertyValues();
//        values.addPropertyValue("name","fat_nan");
//        values.addPropertyValue("age",13);
        values.add("name","fat_nan").add("age",13);
        userBeanDefinition.setPropertyValues(values);
    }

    /**
     * 通过构建器创建AbstractBeanDefinition
     */
    private static void createBeanDefinitionByBuilder() {
        //bean definition 定义bean
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("name","fat_nan");
        beanDefinitionBuilder.addPropertyValue("age",13);
        //获取BeanDefinition
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        //之后可以对beanDefinition进行修改
    }
}
