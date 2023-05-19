package com.fantasybaby.spring.ioc.inject.selection;

import com.fantasybaby.spring.ioc.overview.model.User;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * use {@link org.springframework.beans.factory.annotation.Qualifier} bind a bean name
 * <p>
 * <p>
 * Created on 5/11/2023.
 *
 * @author Fantasy Baby
 */
public class QualifiersNameInjectDemo {
    @Resource
    @Qualifier("user1")
    private User someUser;
    @Autowired
    private List<User> users;

    @Autowired
    @Qualifier
    private List<User> groupUsers;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(QualifiersNameInjectDemo.class);
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(annotationConfigApplicationContext);
        String contextPath = "classpath:/study-ioc-lookup.xml";
        xmlBeanDefinitionReader.loadBeanDefinitions(contextPath);
        annotationConfigApplicationContext.refresh();


        QualifiersNameInjectDemo bean = annotationConfigApplicationContext.getBean(QualifiersNameInjectDemo.class);
        User user1 = bean.someUser;
        System.out.println("someUser is user1 " + user1);
        /**
         * 使用static 声明Bean 会是5个  不用static会延迟加载
         */
        System.out.println("all "+bean.users.size() + " Users [ " + bean.users +"]");
        System.out.println("group "+ bean.groupUsers.size() + " Users " + bean.groupUsers);
    }

    @Bean
    @Qualifier
    public static User user4() {
        User user = new User();
        user.setName("groupUser1");
        return user;
    }

    @Bean
    @Qualifier
    public static User user5() {
        User user = new User();
        user.setName("groupUser2");
        return user;
    }
}
