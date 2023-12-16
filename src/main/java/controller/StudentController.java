package controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import model.Student;
import entity.StudentEntity;
import service.StudentService;

import java.util.List;


@Path("/student")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentController {

    @Inject
    StudentService studentService;

    @GET
    public List<Student> get() {
        return studentService.get();
    }

    @POST
    public StudentEntity create(Student student) {
        StudentEntity studentEntity = studentService.create(student);
        return studentEntity;
    }

    @PUT
    public StudentEntity update(Student student) {
        StudentEntity studentEntity = studentService.update(student);
        return studentEntity;
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        studentService.delete(id);
    }

}