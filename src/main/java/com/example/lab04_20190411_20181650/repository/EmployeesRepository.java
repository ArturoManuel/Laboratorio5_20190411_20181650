package com.example.lab04_20190411_20181650.repository;

import com.example.lab04_20190411_20181650.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeesRepository extends JpaRepository<Employees, Integer> {

    @Query("SELECT e FROM Employees e WHERE e.manager_id.id = :managerId ORDER BY e.first_name, e.last_name")
    List<Employees> findEmployeesByManagerId(@Param("managerId") Integer managerId);

    @Query(value = "SELECT e.*, j.*, h.*, d.*, l.*, c.*, r.* " +
            "FROM employees e " +
            "LEFT JOIN jobs j ON e.job_id = j.job_id " +
            "LEFT JOIN job_history h ON e.employee_id = h.employee_id " +
            "LEFT JOIN departments d ON e.department_id = d.department_id " +
            "LEFT JOIN locations l ON d.location_id = l.location_id " +
            "LEFT JOIN countries c ON l.country_id = c.country_id " +
            "LEFT JOIN regions r ON c.region_id = r.region_id " +
            "WHERE e.employee_id = :employeeId", nativeQuery = true)
    List<Object[]> findCompleteEmployeeInfoByEmployeeId(@Param("employeeId") Integer employeeId);


    @Modifying
    @Query(value = "UPDATE employees\n" +
            "    SET employee_feedback = 'Comentario recibido'\n" +
            "    WHERE employee_id = :employeeId",nativeQuery = true)
    void updateEmployee(@Param("employeeId") Integer employeeId);















}