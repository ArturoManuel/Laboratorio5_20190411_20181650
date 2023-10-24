package com.example.lab04_20190411_20181650.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "departments")
@Getter
@Setter
public class Department implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "department_id")
    private int department_id;

    @Column(name = "department_name")
    private String department_name;


}

