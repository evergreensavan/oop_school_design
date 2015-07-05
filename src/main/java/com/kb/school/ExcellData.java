package com.kb.school;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.IOUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by kbozoglu on 04.07.2015.
 */
public class ExcellData {

    public static List<School> schoolList = new ArrayList<School>();
    public static List<Teacher> teacherList = new ArrayList<Teacher>();
    public static List<Student> studentList = new ArrayList<Student>();
    public static List<Lesson> lessonList= new ArrayList<Lesson>();


    public static void readExcell(){
        InputStream in = null;

        try {
            in = ExcellData.class.getResourceAsStream("/TestData.xls");
            HSSFWorkbook myWorkBook = new HSSFWorkbook(in);

            for (int i = 0; i < myWorkBook.getNumberOfSheets(); i++) {
                HSSFSheet sheet = myWorkBook.getSheetAt(i);

                Iterator<Row> rowIterator = sheet.iterator();

                //Skipping header
                rowIterator.next();

                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();

                    Iterator<Cell> cellIterator = row.cellIterator();

                    if(sheet.getSheetName().equals("SCHOOLS")) {
                        Integer id = new Double(cellIterator.next().getNumericCellValue()).intValue();
                        String name = cellIterator.next().getStringCellValue();
                        School school = new School();
                        school.setId(id);
                        school.setName(name);
                        school.lessons = lessonList;
                        schoolList.add(school);
                    }
                    if(sheet.getSheetName().equals("TEACHERS")) {
                        Integer id = new Double(cellIterator.next().getNumericCellValue()).intValue();
                        String name = cellIterator.next().getStringCellValue();
                        String surname = cellIterator.next().getStringCellValue();
                        Teacher teacher = new Teacher(id, name,surname);
                        teacher.setExperience(new Double(cellIterator.next().getNumericCellValue()).intValue());
                        teacherList.add(teacher);
                    }

                    if(sheet.getSheetName().equals("STUDENTS")) {
                        Integer id = new Double(cellIterator.next().getNumericCellValue()).intValue();
                        String name = cellIterator.next().getStringCellValue();
                        String surname = cellIterator.next().getStringCellValue();
                        Integer age = new Double(cellIterator.next().getNumericCellValue()).intValue();
                        String gender = cellIterator.next().getStringCellValue();
                        Student student = new Student(id, name,surname, age, gender);
                        student.level = new Double(cellIterator.next().getNumericCellValue()).intValue();
                        studentList.add(student);
                    }

                    if(sheet.getSheetName().equals("LESSONS")) {
                        Integer id = new Double(cellIterator.next().getNumericCellValue()).intValue();
                        String title = cellIterator.next().getStringCellValue();
                        Integer teacherId = new Double(cellIterator.next().getNumericCellValue()).intValue();
                        Teacher teacher = findTeacherById(teacherId);
                        Lesson lesson = new Lesson();
                        lesson.setId(id);
                        lesson.setTitle(title);
                        lesson.setTeacher(teacher);
                        lessonList.add(lesson);
                    }

                    if(sheet.getSheetName().equals("LESSON-STUDENT")) {
                        Integer lessonId = new Double(cellIterator.next().getNumericCellValue()).intValue();
                        Integer studentId = new Double(cellIterator.next().getNumericCellValue()).intValue();
                        Lesson lesson = findLessonById(lessonId);
                        lesson.enrollStudent(findStudentById(studentId));
                    }

                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            IOUtils.closeQuietly(in);
        }

    }

    public static Teacher findTeacherById(Integer id) {
        Teacher resultTeacher = null;
        for (Teacher teacher : teacherList)
            if (id.equals(teacher.id)) {
                resultTeacher = teacher;
            }
        return resultTeacher;
    }

    public static Student findStudentById(Integer id) {
        Student resultStudent = null;
        for (Student student : studentList)
            if (id.equals(student.id)) {
                resultStudent = student;
            }
        return resultStudent;
    }

    public static Lesson findLessonById(Integer id) {
        Lesson resultLesson = null;
        for (Lesson lesson : lessonList)
            if (id.equals(lesson.getId())) {
                resultLesson = lesson;
            }
        return resultLesson;
    }

}
