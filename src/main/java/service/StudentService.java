package service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import model.Student;
import entity.StudentEntity;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class StudentService {
    public List<Student> get() {
        List<StudentEntity> listAll = StudentEntity.findAll().list();
        return listAll.stream().map(ie -> {
            return new Student(ie.id, ie.first_name, ie.last_name);
        }).collect(Collectors.toList());
    }

    @Transactional
    public StudentEntity create(Student student) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.first_name = student.getFirst_name();
        studentEntity.last_name = student.getLast_name();
        studentEntity.persist();
        return studentEntity;
    }

    @Transactional
    public StudentEntity update(Student Student) {
        StudentEntity entity = StudentEntity.findById(Student.getId());
        entity.first_name = Student.getFirst_name();
        entity.last_name = Student.getLast_name();
        return entity;
    }

    @Transactional
    public void delete(Long id) {
        StudentEntity.deleteById(id);
    }

}