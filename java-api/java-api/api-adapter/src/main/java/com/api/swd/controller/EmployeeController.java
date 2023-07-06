package com.api.swd.controller;

import com.api.swd.exception.spring.ResourceNotFoundException;
import com.api.swd.model.Employee;
import com.api.swd.model.hibernate.EmployeeDTO;
import com.api.swd.port.IEmployeeRepository;
import com.api.swd.port.hibernate.HEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/vi/employees")
public class EmployeeController {

    @Autowired
    HEmployeeRepository employeeRepository;

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable  long id){
        EmployeeDTO employee = employeeRepository.findById(id)
                            .orElseThrow(
                                () -> new ResourceNotFoundException("Employee not exist with id:" + id)
                            );

        return ResponseEntity.ok(employee);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployee(){
        return employeeRepository.findAll();
    }

}
