package com.fantasybaby.spring.beans.overview;

import com.fantasybaby.spring.ioc.overview.model.User;
import com.fantasybaby.spring.ioc.overview.model.VipUser;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * register bean definition BeanDefinition
 *  <ol>
 *      <li>XML 使用 Bean 标签 </li>
 *      <li>使用Annotation MetaData</li>
 *       <ul>
 *       <li>{@link AnnotationConfigApplicationContext#register} 住</li>
 *      <li>{@link Bean @Bean}</li>
 *      <li> {@link Import @Import}</li>
 *      <li>{@link org.springframework.stereotype.Component @Component}</li>
 *      </ul>
 *      <li>使用api 注册</li>
 *       <ul>
 *        <li> 命名方式{@link org.springframework.beans.factory.support.BeanDefinitionRegistry#registerBeanDefinition(String, BeanDefinition)}</li>
 *        <li>非命名方式{@link org.springframework.beans.factory.support.BeanDefinitionReaderUtils#registerWithGeneratedName(AbstractBeanDefinition, BeanDefinitionRegistry)}</li>
 *        <li> 配置类方式{@link org.springframework.context.annotation.AnnotatedBeanDefinitionReader#register(Class[])}</li>
 *        </ul>
 *  </ol>
 * <p>
 * Created on 4/4/2023.
 *
 * @author Fantasy Baby
 */
@Import(RegisterBeanDefinitionDemo.InnerConfig.class)
public class RegisterBeanDefinitionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        //注册配置类
        annotationConfigApplicationContext.register(RegisterBeanDefinitionDemo.class);
        // 通过名称注册
        registerByApi("beanNameUser", annotationConfigApplicationContext);
        //不指定名称
        registerByApi(null, annotationConfigApplicationContext);
        //启动上下文
        annotationConfigApplicationContext.refresh();
        /**
         * 1.通过{@link Import @Import} 引入配置类
         * 2.通过annotationConfigApplicationContext.register 引入对应的Bean
         */
        Map<String, InnerConfig> beansOfType = annotationConfigApplicationContext.getBeansOfType(InnerConfig.class);
        Map<String, User> userBeans = annotationConfigApplicationContext.getBeansOfType(User.class);

        System.out.println("上下文中所有的ConfigBean" + beansOfType);
        System.out.println("上下文中所有的UserBeans" + userBeans);
        annotationConfigApplicationContext.close();
    }


    /**
     * 注册api
     * 使用api注册
     *
     * @param beanName bean名字
     * @param registry 注册表
     */
    public static void registerByApi(String beanName, BeanDefinitionRegistry registry) {
        GenericBeanDefinition userBeanDefinition = new GenericBeanDefinition();
        userBeanDefinition.setBeanClass(User.class);
        //设置属性值
        MutablePropertyValues values = new MutablePropertyValues();
        values.add("name", "fat_nan").add("age", 13);
        userBeanDefinition.setPropertyValues(values);
        if (StringUtils.hasText(beanName)) {
            registerUseName(registry, userBeanDefinition, "registerUserNameBean");
        } else {
            registerNoName(registry, userBeanDefinition);
        }

    }

    /**
     * 注册使用名字
     *
     * @param registry           注册表
     * @param userBeanDefinition 用户bean定义
     */
    private static void registerUseName(BeanDefinitionRegistry registry, GenericBeanDefinition userBeanDefinition, String beanName) {
        registry.registerBeanDefinition(beanName, userBeanDefinition);
    }

    /**
     * 注册默认名字
     *
     * @param registry           注册表
     * @param userBeanDefinition 用户bean定义
     */
    private static void registerNoName(BeanDefinitionRegistry registry, GenericBeanDefinition userBeanDefinition) {
        BeanDefinitionReaderUtils.registerWithGeneratedName(userBeanDefinition, registry);
    }

    @Component
    public static class InnerConfig {
        @Bean({"defaultUser", "clark"})
        public User user() {
            User user = new User();
            user.setAge(12);
            user.setName("clark");
            return user;
        }

        @Bean({"vipUser", "fantasyBaby"})
        public VipUser vipUser() {
            VipUser user = new VipUser();
            user.setAge(12);
            user.setName("fantasyBaby");
            return user;
        }
    }


}
