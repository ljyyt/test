package com.le.springboot.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.List;
import java.util.Map;

/**
 * @author lijunyi
 * @date 2019/12/8 22:44
 */
@PropertySource(value = {"classpath:person.properties"})
@Component
@ConfigurationProperties(prefix = "person")
//#JSR303数据效验
@Validated
public class Person {

    //@Email
    //@Value("${person.last-name}")
    String lastName;
    //SpEL
    //@Value("#{2*3}")
    int age;
    String sex;
    Map<String,String> skill;
    List<String> hobby;
    Dog dog;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Map <String, String> getSkill() {
        return skill;
    }

    public void setSkill(Map <String, String> skill) {
        this.skill = skill;
    }

    public List <String> getHobby() {
        return hobby;
    }

    public void setHobby(List <String> hobby) {
        this.hobby = hobby;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + lastName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", skill=" + skill +
                ", hobby=" + hobby +
                ", dog=" + dog +
                '}';
    }
}
