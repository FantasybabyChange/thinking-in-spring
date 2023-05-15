package com.fantasybaby.spring.ioc.inject.constructor.holder;

import com.fantasybaby.spring.ioc.overview.model.User;

/**
 * Created on 5/11/2023.
 *
 * @author Fantasy Baby
 */
public class UserHolder {
    private User user;

    public UserHolder() {
    }

    public UserHolder(User user) {
        this.user = user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
