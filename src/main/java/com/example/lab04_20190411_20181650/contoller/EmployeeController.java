package com.example.lab04_20190411_20181650.contoller;


import com.example.lab04_20190411_20181650.entity.Employees;
import com.example.lab04_20190411_20181650.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeesRepository employeesRepository;

    @GetMapping("/listar")
    List<Employees> listarEmployees(){return employeesRepository.findAll();}


    @GetMapping("/buscar")
    public List<Employees> buscarEmployees(@RequestParam("id") Integer id){
        Employees employee = employeesRepository.findById(id).orElse(null);
        List<Employees> result = new ArrayList<>();
        if(employee != null) {
            result.add(employee);
        }
        return result;
    }

    @PutMapping("/actualizar-comentario/{employeeId}")
    public void updateEmployeeComment(@PathVariable Integer employeeId) {
        employeesRepository.updateEmployee(employeeId);
    }



    @GetMapping("/byManager")
    public List<Employees> findEmployeesByManager(@RequestParam("managerId") Integer managerId) {
        return employeesRepository.findEmployeesByManagerId(managerId);
    }

    @GetMapping("/completeInfo")
    public List<Object[]> findCompleteEmployeeInfo(@RequestParam("employeeId") Integer employeeId) {
        return employeesRepository.findCompleteEmployeeInfoByEmployeeId(employeeId);
    }


}
