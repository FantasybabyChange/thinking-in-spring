package com.fantasybaby.spring.beans.overview;

import com.fantasybaby.spring.ioc.overview.container.ApplicationContextIocContainer;
import com.fantasybaby.spring.ioc.overview.model.User;
import com.fantasybaby.spring.ioc.overview.model.UserLook;
import com.fantasybaby.spring.ioc.overview.model.VipUser;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

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
public class RegisterBeanDefinitionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        //注册配置类
        annotationConfigApplicationContext.register(ApplicationContextIocContainer.class);
        //启动上下文
        annotationConfigApplicationContext.refresh();
        Map<String, Object> beansWithAnnotation = annotationConfigApplicationContext.getBeansWithAnnotation(UserLook.class);
        System.out.println("通过ApplicationContext和注解查找Bean" + beansWithAnnotation);
        annotationConfigApplicationContext.close();
    }

    @Bean
    public User user() {
        User user = new User();
        user.setAge(12);
        user.setName("clark");
        return user;
    }

    @Bean
    public VipUser vipUser() {
        VipUser user = new VipUser();
        user.setAge(12);
        user.setName("fantasybaby");
        return user;
    }
}
