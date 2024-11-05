package com.example.restapipractice.Controller;

import com.example.restapipractice.Service.StudentService;
import com.example.restapipractice.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping()
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.saveStudent(student),HttpStatus.OK);
    }


    @GetMapping("{id}")
    public ResponseEntity<Student> getById(@PathVariable("id") int id){
        return new ResponseEntity<>(studentService.getStudentById(id),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> update(@RequestBody Student student, @PathVariable("id") int id){
        return new ResponseEntity<>(studentService.updateStudent(student,id),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@RequestBody String student , @PathVariable("id") int id){
        studentService.deleteStudent(student,id);
        return new ResponseEntity<>("student Deleted Successfully",HttpStatus.OK);
    }
}
