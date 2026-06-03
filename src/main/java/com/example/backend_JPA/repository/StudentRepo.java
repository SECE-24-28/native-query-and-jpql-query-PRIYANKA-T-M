//Controller->Service
package com.example.backend_JPA.repository;


import com.example.backend_JPA.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
    Student findByRollNo(int rollNo);
    public List<Student> findByTechAndGender(String tech,String gender);
    public List<Student> findByTech(String tech);
    public List<Student> findByGender(String gender);
//    public List<Student> findStudentByName(String name);
    //native query
    @Query(nativeQuery=true,value="SELECT * FROM student WHERE tech=:tech AND gender=:gender")
    List<Student> findByGenAndTech(@Param("tech") String tech, @Param("gender") String gender);
    @Query(nativeQuery=true,value="SELECT s FROM student WHERE s.getName=:julie ")
    List<Student> findByName(@Param("julie") String name);

}
