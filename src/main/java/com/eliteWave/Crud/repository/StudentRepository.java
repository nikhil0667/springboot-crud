package com.eliteWave.Crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eliteWave.Crud.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
