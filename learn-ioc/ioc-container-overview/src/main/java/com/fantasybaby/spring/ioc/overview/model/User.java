package com.fantasybaby.spring.ioc.overview.model;

import org.springframework.core.io.Resource;

import java.util.Arrays;
import java.util.List;

/**
 * Created on 3/22/2023.
 *
 * @author FantasyBaby
 */

public class User {
    private String name;
    private Integer age;

    private Resource path;

    private CityEnum city;
    private CityEnum[] workCities;
    private List<CityEnum> liveCities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Resource getPath() {
        return path;
    }

    public void setPath(Resource path) {
        this.path = path;
    }

    public CityEnum getCity() {
        return city;
    }

    public void setCity(CityEnum city) {
        this.city = city;
    }

    public CityEnum[] getWorkCities() {
        return workCities;
    }

    public void setWorkCities(CityEnum[] workCities) {
        this.workCities = workCities;
    }

    public List<CityEnum> getLiveCities() {
        return liveCities;
    }

    public void setLiveCities(List<CityEnum> liveCities) {
        this.liveCities = liveCities;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", path=" + path +
                ", city=" + city +
                ", workCities=" + Arrays.toString(workCities) +
                ", liveCities=" + liveCities +
                '}';
    }
}
