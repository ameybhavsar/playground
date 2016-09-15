package com.nyu.edu.services.api;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amey on 9/11/2016.
 */
public class StudentUtil {

    public static List<Student> currentStudentList = new ArrayList<>();

    static public List<Student> initializeStudentList() {
        List<Student> studentList = new ArrayList<>();
        Student student1 = new Student("Amey", "Bhavsar", "M");
        Student student2 = new Student("Bhavisha", "Dawada", "F");
        Student student3 = new Student("Mrunal", "Bhavsar", "F");
        currentStudentList.add(student1);
        currentStudentList.add(student2);
        currentStudentList.add(student3);
        return currentStudentList;
    }
}
