package net.mfsiat.springbootrestapi.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import net.mfsiat.springbootrestapi.bean.Student;
import org.springframework.web.bind.annotation.*;

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

    // Spring boot REST API with Request Param
    // http://localhost:8080/students/query?id=1&firstName=Nasirul&lastName=Islam
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        return new Student(id, firstName, lastName);
    }

    // Spring boot REST API that handles HTTP POST Request
    // @PostMapping and @RequestBody
    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@org.jetbrains.annotations.NotNull @RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    // Below code block is redundant
    @PostMapping("students/create-student-test")
    public ResponseEntity<?> createStudentTest(@RequestBody Student student) {
        try {
            System.out.println(student.getId());
            System.out.println(student.getFirstName());
            System.out.println(student.getLastName());

            // Additional processing logic, if any

            return ResponseEntity.ok(student);
        } catch (Exception e) {
            // Log the exception for debugging purposes
//            e.printStackTrace();
//            e.getMessage();

            // Return a response with an error message
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input. Please check your request.");
        }
    }

    // Spring Boot REST API that handles HTTP PUT Request - updating existing resource
    @PutMapping("students/{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

//    Spring boot REST API that handles HTTP DELETE Request - deleting the existing resource
    @DeleteMapping("students/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return "Student deleted successfully!";
    }
}
