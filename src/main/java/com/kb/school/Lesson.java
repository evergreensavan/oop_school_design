package com.kb.school;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kbozoglu on 04.07.2015.
 */
public class Lesson {

    private Integer id;
    private String title;
    private Teacher teacher;
    public List<Student> students = new ArrayList<Student>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        if (ValidationUtils.validateName(title)) {
            this.title = title;
        }
        else {
            System.out.println("You could not set the Lesson name correctly");
        }
    }
    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public void enrollStudent(Student std){
        if(students.size() < 30) {
            students.add(std);
        }
        else{
            System.out.println("This lesson is full !");
        }
    }
    public void deleteStudent(Student std){
//        int idxWillRemove = -1;
//        for(int i = 0; i < students.size(); i++){
//            if (students.get(i).getStudentNumber().equals(std.getStudentNumber())){
//                idxWillRemove = i;
//                break;
//            }
//        }
        students.remove(std);
    }
    public Integer getNoOfStudents() { return students.size(); }
}
