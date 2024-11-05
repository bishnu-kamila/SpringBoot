package com.example.restapipractice.Service;

import com.example.restapipractice.ResourceNotFoundException;
import com.example.restapipractice.Student;
import com.example.restapipractice.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{


    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(int id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            return student.get();
        }else {
            throw new ResourceNotFoundException("Student","id",id);
        }

    }

    @Override
    public Student getElementById(Integer id) {
        Optional<Student> student =  studentRepository.findById(id);
        if(student.isPresent()){
            return student.get();
        }else {
            throw new ResourceNotFoundException("Student", "id", id);
        }
    }

    @Override
    public Student updateStudent(Student student, Integer id) {
        Student availableStudent = studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student" ,"id", id));
        availableStudent.setName(student.getName());
        availableStudent.setDepartment(student.getDepartment());
        availableStudent.setAddress(student.getAddress());
        studentRepository.save(availableStudent);
        return availableStudent;
    }

    @Override
    public void deleteStudent(String stud, Integer id) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student","id",id));
        studentRepository.delete(existingStudent);
    }


}
