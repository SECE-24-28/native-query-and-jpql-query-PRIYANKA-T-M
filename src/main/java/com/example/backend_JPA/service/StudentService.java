//Controller->Service->Repository
package com.example.backend_JPA.service;

import com.example.backend_JPA.dto.StudentDto;
import com.example.backend_JPA.model.Student;
import com.example.backend_JPA.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepo stuRepo;

//    Student
    public List<Student> getAllStudents() {

        return stuRepo.findAll();
    }
//
//    public Student addStudent(Student student){
//
//        return stuRepo.save(student);
//    }

    public List<Student> addStudents(List<Student> stuList){

        return stuRepo.saveAll(stuList);
    }
    public Student getStudentByRollNo(int rollNo){

        return stuRepo.findById(rollNo).orElse(null);
    }

    public Student updateStudent(Student student){
        return stuRepo.save(student);


    }
    public void deleteAll(){

        stuRepo.deleteAll();
    }
    public void deleteStudentByRollNo(int rollNo){

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
    //StudentDto
    public StudentDto getStudentByRollNo1(int rollNo){
        Student s1=stuRepo.findByRollNo(rollNo);
        return convertStudentToDto(s1);


    }
    public StudentDto addStudent1(StudentDto std){
        Student s1=convertDtoToStudent(std);
        Student s2=stuRepo.save(s1);
        return convertStudentToDto(s2);

    }
    public StudentDto convertStudentToDto(Student s1){
        StudentDto std=new StudentDto();
        std.setRollNo(s1.getRollNo());
        std.setName(s1.getName());
        std.setTech(s1.getTech());
        std.setGender(s1.getGender());
        return std;
    }
    public Student convertDtoToStudent(StudentDto std1){
        Student s2=new Student();
        s2.setRollNo(std1.getRollNo());
        s2.setName(std1.getName());
        s2.setTech(std1.getTech());
        s2.setGender(std1.getGender());
        return s2;
    }


    //pagination
    public Page<Student> getAllStudent(int page,int size){
        return stuRepo.findAll(
                PageRequest.of(page,size)

        );
    }


}

