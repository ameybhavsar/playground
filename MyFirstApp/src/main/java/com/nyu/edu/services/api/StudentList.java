package com.nyu.edu.services.api;

import java.util.List;

/**
 * Created by Amey on 9/11/2016.
 */
public class StudentList {

    private List<Student> students;

    public  StudentList() {
        students = StudentUtil.initializeStudentList();
    }

    public List<Student> getStudents() {
        return students;
    }

    public  List<Student> addStudent(Student student){
        students.add(student);
        return students;
    }

    public  List<Student> addStudents(List<Student> studentList)
    {
        students.addAll(studentList);
        return students;
    }
}
