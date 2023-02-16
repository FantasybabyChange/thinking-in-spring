package com.fantasybaby.javabean.ioc.pojo;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * Created on 2/16/2023.
 *
 * @author FantasyBaby
 */
public class BeanInfoDemo {
    public static void main(String[] args) throws IntrospectionException {
        /**
         * 只找当前类
         */
        BeanInfo beanInfo = Introspector.getBeanInfo(PersonPojo.class,Object.class);
        /**
         * 获取配置元信息
         */
        Stream.of(beanInfo.getPropertyDescriptors()).forEach(it-> System.out.println(it));

        Stream.of(beanInfo.getPropertyDescriptors()).forEach(it-> {
            /**
             * 获取属性名称和类型
             */
            Class<?> propertyType = it.getPropertyType();
            String name = it.getName();
            if("age".equals(name)){
                /**
                 * 将text 转换为其他类型
                 */
                it.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
//                it.createPropertyEditor()
            }
        });

    }

    /**
     *  String 转换 Integer
     * 实现 PropertyEditor接口
     *  或者实现 PropertyEditorSupport
     */
    class StringToIntegerPropertyEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            Integer.valueOf(text);
            setValue(text);
        }
    }
}
