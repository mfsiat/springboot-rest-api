package net.mfsiat.springbootrestapi.controller;

import net.mfsiat.springbootrestapi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    // Create the Spring Boot REST API
    // That returns java bean as a JSON to the client

    // http://localhost:8080/student
    @GetMapping("student")
    public Student getStudent(){
        Student student = new Student(1, "Nasirul", "Islam");
        return student;
    }

    // Create the java method that returns the list of students
    // After that make it a rest api using java annotations
    // http://localhost:8080/students
    @GetMapping("students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Nasirul", "Islam"));
        students.add(new Student(2, "Wasif", "Shikdar"));
        students.add(new Student(3, "Shiblur", "Rahman"));
        students.add(new Student(4, "Maliha", "Shamshed"));
        students.add(new Student(5, "Saiful", "Islam"));

        // Return the object
        return students;
    }

    // Spring Boot REST API with Path Variable
    // {id} - URI template variable
    // http://localhost:8080/student/1
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName){
        return new Student(studentId, firstName, lastName);
    }
}
