package com.nyu.edu.services.resources;

import com.codahale.metrics.annotation.Timed;
import com.nyu.edu.services.api.Student;
import com.nyu.edu.services.api.StudentUtil;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Amey on 9/11/2016.
 */


@Path("/student")
@Produces(MediaType.APPLICATION_JSON)
public class StudentResource {

    @GET
    @Timed
    public Student getStudentByName(){
        Student student = new Student(1, "Amey Bhavsar","Male","abc@gmail.com", null);
        return student;
    }

    @GET
    @Timed
    @Path("/list")
    public List<Student> getStudentList(){
        return StudentUtil.currentStudentList;
    }

    @POST
    @Timed
    @Path("/add")
    public void addStudent(Student student){
        StudentUtil.currentStudentList.add(student);
    }

    /*@POST
    @Timed
    @Path("/add")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addStudent(@FormParam("name") name){
        StudentUtil.generateStudentList();
        StudentList.addStudent(student);
    }*/
}
