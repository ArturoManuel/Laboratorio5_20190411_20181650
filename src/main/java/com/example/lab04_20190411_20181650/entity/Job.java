package com.example.lab04_20190411_20181650.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "jobs")
@Getter
@Setter
public class Job implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "job_id")
    private String job_id;

    @Column(name = "job_title")
    private String job_title;

    @Column(name = "min_salary")
    private int min_salary;

    @Column(name = "max_salary")
    private int max_salary;
}