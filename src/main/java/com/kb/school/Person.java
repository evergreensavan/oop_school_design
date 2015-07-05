package com.kb.school;

/**
 * Created by kbozoglu on 04.07.2015.
 */
public class Person {
    public Integer  id;
    private String firstName;
    private String lastName;
    public Integer age;

    public Person(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId(){ return id; }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFullName(){
        return getFirstName() + " " + getLastName();
    }
}
