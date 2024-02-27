package com.fantasybaby.spring.beans.scope.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.BeanNameAware;

/**
 * test scope bean
 * Created on 2024/2/22.
 *
 * @author Fantasy Baby
 */
public class MusicDo implements BeanNameAware {
    private String beanName;
    private String name;
    private String type;

    private Integer volume;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "MusicDo{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", volume=" + volume +
                '}';
    }

    @PostConstruct
    public void init() {
        System.out.printf("init bean %s \n", beanName);
    }

    @PreDestroy
    public void preDestroy() {
        System.out.printf("preDestroy bean %s \n", beanName);
    }

    @Override
    public void setBeanName(String beanName) {
        this.beanName = name;
    }
}
