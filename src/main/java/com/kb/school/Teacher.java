package com.kb.school;

/**
 * Created by kbozoglu on 04.07.2015.
 */
public class Teacher extends Person {
    private Integer experience;

    public Teacher(Integer id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }
}
