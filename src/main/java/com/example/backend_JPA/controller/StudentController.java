package com.example.backend_JPA.controller;

import com.example.backend_JPA.model.Student;
import com.example.backend_JPA.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService s;
    @GetMapping("get-students")
    public List<Student> getAllStudents() {
        return s.getAllStudents();
    }

    @PostMapping("create-student")
    public String addStudent(@RequestBody Student student){
        Student res=s.addStudent(student);
        if(res!=null){
            return "Student added successfully";
        }
        else{
            return "Student not added";
        }


    }
    @PostMapping("create-students")
    public String addStudents(@RequestBody List<Student>stuList){
        List<Student> students= s.addStudents(stuList);
        if(students!=null){
            return "Students added successfully";
        }
        else{
            return "Students not added";
        }
    }

    @GetMapping("get-student/{rollNo}")
    public Student getStudentByRollNo(@PathVariable String rollNo){
        return s.getStudentByRollNo(rollNo);
    }
    @PutMapping("update-student")
    public String updateStudent(@RequestBody Student student){
        Student stu=s.updateStudent(student);
        if(stu!=null){
            return "Student updated successfully";
        }
        else{
            return "Student not updated";
        }
    }
    @DeleteMapping("deleteAll")
    public String deleteAllStudents(){
        s.deleteAll();
        return "All Students have been deleted successfully";
    }
    @DeleteMapping("delete/{rollNo}")
    public String deleteStudentByRollNo(@PathVariable String rollNo){
        s.deleteStudentByRollNo(rollNo);
        return "Student with rollNo: "+rollNo +"have been deleted successfully";
    }

    @GetMapping("/custom")
    public List<Student> getStudentsByTechAndGender(@Param("gender") String gender,@Param("tech") String tech){
        return s.getStudentsByTechAndGender(tech,gender);
    }

    @GetMapping("/tech")
    public List<Student> getByTech(@Param("tech") String tech){
        return s.getStudentByTech(tech);
    }
    @GetMapping("/gender")
    public List<Student> getByGender(@Param("gender") String gender){
        return s.getStudentByGender(gender);
    }
//    @GetMapping("/name")
//    public List<Student> getByName1(@Param("name") String name){
//        return s.getStudentByName(name);
//    }

    //native query
    @GetMapping("/filter")
    public List<Student> getStudentsByGenAndTech(@Param("gender") String gender,@Param("tech") String tech){
        return s.getStudentsByGenAndTech(gender,tech);
    }

    @GetMapping("/name")
    public List<Student> getByName(@Param("name") String name){
        return s.getByName(name);
    }


}
