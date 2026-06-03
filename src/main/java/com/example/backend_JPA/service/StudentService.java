//Controller->Service->Repository
package com.example.backend_JPA.service;

import com.example.backend_JPA.model.Student;
import com.example.backend_JPA.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepo stuRepo;

    public List<Student> getAllStudents() {
        return stuRepo.findAll();
    }

    public Student addStudent(Student student){
        return stuRepo.save(student);
    }

    public List<Student> addStudents(List<Student> stuList){
        return stuRepo.saveAll(stuList);
    }
    public Student getStudentByRollNo(String rollNo){
        return stuRepo.findById(rollNo).orElse(null);
    }

    public Student updateStudent(Student student){
        return stuRepo.save(student);


    }
    public void deleteAll(){
        stuRepo.deleteAll();
    }
    public void deleteStudentByRollNo(String rollNo){
        stuRepo.deleteById(rollNo);
    }
    public List<Student> getStudentsByTechAndGender(String tech,String gender){
        return stuRepo.findByTechAndGender(tech,gender);
    }
    public List<Student> getStudentByTech(String tech){
        return stuRepo.findByTech(tech);
    }
    public List<Student> getStudentByGender(String gender){
        return stuRepo.findByGender(gender);
    }
//    public List<Student> getStudentByName(String name){
//        return stuRepo.findStudentByName(name);
//    }

    //native queried method
    public List<Student> getStudentsByGenAndTech(@Param("gender") String gender,@Param("tech") String tech){
        return stuRepo.findByGenAndTech(gender,tech);
    }

    public List<Student> getByName(String name) {
        return stuRepo.findByName(name);
    }
}

