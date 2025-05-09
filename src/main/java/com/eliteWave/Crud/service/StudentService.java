package com.eliteWave.Crud.service;

import java.sql.Struct;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eliteWave.Crud.model.Student;
import com.eliteWave.Crud.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudent(Student student) {
        Student eStudent = this.getStudentById(student.getId());
        if (eStudent == null) {
            return null;
        }
        eStudent.setName(student.getName());
        eStudent.setAge(student.getAge());
        eStudent.setEmail(student.getEmail().toLowerCase());
        return this.studentRepository.save(eStudent);
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}