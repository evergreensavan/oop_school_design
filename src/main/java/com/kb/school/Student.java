package com.kb.school;

/**
 * Created by kbozoglu on 04.07.2015.
 */
public class Student extends Person{
    private String gender;
    public Integer level;

    public Student(Integer id, String firstName, String lastName, Integer age, String gender) {
        super(id, firstName, lastName);
        this.age = age;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getLevel() {
        return level;
    }
    public void setLevel(Integer level) {
        this.level = level;
    }
}
