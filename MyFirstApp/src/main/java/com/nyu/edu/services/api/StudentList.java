package com.nyu.edu.services.api;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amey on 9/11/2016.
 */
public class StudentList {

    private static List<Student> students;

    public  StudentList() {
        students = new ArrayList<>();
    }

    public static List<Student> getStudents() {
        return students;
    }

    public static List<Student> addStudent(Student student){
        students.add(student);
        return  students;
    }

    public static List<Student> addStudents(List<Student> studentList)
    {
        students.addAll(studentList);
        return students;
    }
}
