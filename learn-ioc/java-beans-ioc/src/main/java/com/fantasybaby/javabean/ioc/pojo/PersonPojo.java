package com.fantasybaby.javabean.ioc.pojo;

/**
 *  贫血模型 的一个pojo
 * Created on 2/16/2023.
 * java bean 中
 *   setter 叫做  writable
 *   getter 叫做  Readable
 *   filed 叫 property
 * @author fantasybaby
 */
public class PersonPojo {
    private String name;
    private Integer age;

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
}
