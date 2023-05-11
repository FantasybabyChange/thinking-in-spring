package com.fantasybaby.spring.ioc.inject.setter.holder;

import com.fantasybaby.spring.ioc.overview.model.User;

/**
 * Created on 5/11/2023.
 *
 * @author Fantasy Baby
 */
public class UserHolder {
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
