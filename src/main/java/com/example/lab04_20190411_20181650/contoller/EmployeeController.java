package com.example.lab04_20190411_20181650.contoller;


import com.example.lab04_20190411_20181650.entity.Employees;
import com.example.lab04_20190411_20181650.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
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


    @GetMapping("/byManager")
    public List<Employees> findEmployeesByManager(@RequestParam("managerId") Integer managerId) {
        return employeesRepository.findEmployeesByManagerId(managerId);
    }

    @GetMapping("/completeInfo")
    public List<Object[]> findCompleteEmployeeInfo(@RequestParam("employeeId") Integer employeeId) {
        return employeesRepository.findCompleteEmployeeInfoByEmployeeId(employeeId);
    }

    @PostMapping("/updateFeedback")
    public ResponseEntity<String> updateEmployeeFeedback(@RequestParam("employeeId") Integer employeeId, @RequestParam("feedback") String feedback) {
        try {
            employeesRepository.updateEmployeeFeedback(employeeId, feedback);
            return new ResponseEntity<>("Feedback actualizado con éxito", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el feedback", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/updateMeeting")
    public ResponseEntity<String> updateEmployeeMeetingStatus(@RequestParam("employeeId") Integer employeeId, @RequestParam("managerId") Integer managerId) {
        try {
            employeesRepository.updateMeetingStatus(employeeId, managerId);
            return new ResponseEntity<>("Se ejecuto el api", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al ejecutar el api", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
