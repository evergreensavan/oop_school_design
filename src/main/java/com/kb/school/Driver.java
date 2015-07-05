package com.kb.school;

/**
 * Created by kbozoglu on 04.07.2015.
 */
public class Driver {

    public static void main(String[] args){
        ExcellData.readExcell();
        School sch = ExcellData.schoolList.get(0);
        printSchool(sch);
    }

    private static void printSchool(School sch){

        for(int i = 0; i < sch.getNoOfLessons(); i++){
            System.out.println(sch.lessons.get(i).getTitle() + " lesson's teacher is " + sch.lessons.get(i).getTeacher().getFullName());
            System.out.println("It has " + sch.lessons.get(i).getNoOfStudents() + " students have enrolled:" );
            for(int j = 0; j < sch.lessons.get(i).getNoOfStudents(); j ++){
                Student std = sch.lessons.get(i).students.get(j);
                System.out.println(std.id + " " + std.getFullName() + " " + std.getAge() + " " + std.getGender());
            }
            System.out.println("----------");
        }

    }

}
