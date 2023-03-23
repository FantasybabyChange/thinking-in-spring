package com.fantasybaby.spring.ioc.overview.repository;

import com.fantasybaby.spring.ioc.overview.model.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

/**
 * Created on 3/22/2023.
 *
 * @author Fantasy Baby
 */
public class UserRepository {
    /**
     * 自定义bean
     */
    Collection<User> users;
    /**
     * 内建非 Bean 对象(依赖)
     */
    BeanFactory beanFactory;

    /**
     *  使用延迟注入
     */
    private ObjectFactory<User> user1ObjectFactory;

    private ObjectFactory<ApplicationContext> applicationContextObjectFactory;
    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public ObjectFactory<User> getUser1ObjectFactory() {
        return user1ObjectFactory;
    }

    public void setUser1ObjectFactory(ObjectFactory<User> user1ObjectFactory) {
        this.user1ObjectFactory = user1ObjectFactory;
    }

    public ObjectFactory<ApplicationContext> getApplicationContextObjectFactory() {
        return applicationContextObjectFactory;
    }

    public void setApplicationContextObjectFactory(ObjectFactory<ApplicationContext> applicationContextObjectFactory) {
        this.applicationContextObjectFactory = applicationContextObjectFactory;
    }
}
