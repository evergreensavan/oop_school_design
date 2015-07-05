package com.kb.school;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kbozoglu on 04.07.2015.
 */
public class School {
    private static String[] schoolNames = new String[]{"Yeditepe","ITU", "Sabanci", "Bogazici"};

    private Integer id;
    private String name;
    public List<Lesson> lessons = new ArrayList<Lesson>();
    //private Integer noOfLessons = lessons.size();


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        if (School.validateName(name)) {
            this.name = name;
            append();
        }
    }
    private String append(){
        name = "T.C. " + name + " University";
        return name;
    }

    private static boolean validateName(String name){

        if(ValidationUtils.validateName(name) == false) {
            System.out.println("You can not set the School name correctly");
            return false;
        }
        for (int i = 0; i < School.schoolNames.length; i++) {
            if (name.equals(schoolNames[i])) {
                break;
            }
            if (i == School.schoolNames.length) {
                System.out.println("You can not set the School name correctly");
                return false;
            }
        }
        return true;
    }

    public void openLesson(Lesson lesson){
        lessons.add(lesson);
    }

    public Integer getNoOfLessons() {
        return lessons.size();
    }
}
