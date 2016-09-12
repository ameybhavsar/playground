package com.nyu.edu.services.api;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amey on 9/11/2016.
 */
public class StudentUtil {

    static public List<Student> generateStudentList(){
        List<Student> studentList = new ArrayList<>();
        Student student1 = new Student("Amey", "Bhavsar", "M");
        Student student2 = new Student("Bhavisha", "Dawada", "F");
        Student student3 = new Student("Mrunal", "Bhavsar", "F");
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        StudentList students = new StudentList();
        return  students.addStudents(studentList);
    }
}
