package com.example.lab04_20190411_20181650.repository;

import com.example.lab04_20190411_20181650.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, String> {
}