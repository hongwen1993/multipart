package com.kagura.demo;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2020/12/4 7:17
 * @since 1.0.0
 */
public class User {

    private volatile Integer age = 0;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
