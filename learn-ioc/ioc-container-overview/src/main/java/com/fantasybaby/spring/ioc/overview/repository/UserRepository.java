package com.fantasybaby.spring.ioc.overview.repository;

import com.fantasybaby.spring.ioc.overview.model.User;
import org.springframework.beans.factory.BeanFactory;

import java.util.Collection;
import java.util.List;

/**
 * Created on 3/22/2023.
 *
 * @author Fantasy Baby
 */
public class UserRepository {
    Collection<User> users;
    BeanFactory beanFactory;
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
}
