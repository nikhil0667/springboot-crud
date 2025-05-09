package com.eliteWave.Crud.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.eliteWave.Crud.model.Student;
import com.eliteWave.Crud.repository.StudentRepository;
import com.eliteWave.Crud.service.StudentService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService service;

	@PostMapping
	public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student) {
		return ResponseEntity.ok(service.addStudent(student));
	}

	@GetMapping
	public ResponseEntity<List<Student>> getAllStudent() {
		return ResponseEntity.ok(service.getAllStudents());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable int id) {
		Student student = service.getStudentById(id);
		return (student != null) ? ResponseEntity.ok(student)
				: ResponseEntity
						.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
		student.setId(id);
		Student updated = service.updateStudent(student);
		if (updated == null) {
			return ResponseEntity.notFound().build(); // if student not found
		}
		return ResponseEntity.ok(updated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
		service.deleteStudent(id);
		return ResponseEntity.noContent().build();
	}
}