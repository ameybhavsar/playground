package com.nyu.edu.services.resources;

import com.codahale.metrics.annotation.Timed;
import com.nyu.edu.services.api.Student;
import com.nyu.edu.services.api.StudentList;
import com.nyu.edu.services.api.StudentUtil;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Amey on 9/11/2016.
 */


@Path("/student")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentResource {

    @GET
    @Timed
    public Student getStudentByName(){
        Student student = new Student("Amey","Bhavsar","F");
        return student;
    }

    @GET
    @Timed
    @Path("/list")
    public List<Student> getStudentList(){
        StudentUtil.generateStudentList();
        return StudentList.getStudents();
    }

    @POST
    @Timed
    @Path("/add")
    public void addStudent(Student student){
        StudentUtil.generateStudentList();
        StudentList.addStudent(student);
    }
}
