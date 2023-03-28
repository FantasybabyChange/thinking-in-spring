package com.fantasybaby.spring.ioc.overview.container;

import com.fantasybaby.spring.ioc.overview.model.User;
import com.fantasybaby.spring.ioc.overview.model.UserLook;
import com.fantasybaby.spring.ioc.overview.model.VipUser;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * 使用 {@link AnnotationConfigApplicationContext} 作为容器查找bean
 * {@link org.springframework.context.support.ClassPathXmlApplicationContext }同理
 * Created on 3/28/2023.
 *
 * @author Fantasy Baby
 */
public class ApplicationContextIocContainer {
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
