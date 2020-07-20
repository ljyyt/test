package com.le.springboot.bean;

import org.springframework.stereotype.Component;

/**
 * @author lijunyi
 * @date 2019/12/8 23:30
 */
@Component
public class Dog {
    String name;
    String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String collor) {
        this.color = collor;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
