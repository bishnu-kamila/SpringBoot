package com.example.restapipractice.Service;

import com.example.restapipractice.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student saveStudent(Student student);
    Student getStudentById(int id);

    Student getElementById(Integer id);

    Student updateStudent(Student student , Integer id);

    void deleteStudent(String stud , Integer id);

}
