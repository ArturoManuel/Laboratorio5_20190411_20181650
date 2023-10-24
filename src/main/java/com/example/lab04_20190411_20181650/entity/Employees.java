package com.example.lab04_20190411_20181650.entity;
import jakarta.persistence.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name= "employees")
@Getter
@Setter
public class Employees implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false)
    private int id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "hire_date")
    private Timestamp hire_date;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job_id;

    @Column(name = "salary")
    private double salary;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employees manager_id;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department_id;

    @Column(name = "meeting")
    private int meeting;

    @Column(name = "meeting_date")
    private Timestamp meeting_date;
}

