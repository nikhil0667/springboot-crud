package com.eliteWave.Crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.NonFinal;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private int id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 30, message = "Name must be 2-30 characters")
    @Column(name = "name", nullable = false)
    private String name;

    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    @Column(name = "email", nullable = false)
    private String email;

    @Min(value = 1, message = "Age must be greater than 0")
    @Column(name = "age", nullable = false)
    private int age;

}
