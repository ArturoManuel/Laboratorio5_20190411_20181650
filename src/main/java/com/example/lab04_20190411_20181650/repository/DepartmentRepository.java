package com.example.lab04_20190411_20181650.repository;

import com.example.lab04_20190411_20181650.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}