package net.mfsiat.springbootrestapi.controller;

import net.mfsiat.springbootrestapi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
