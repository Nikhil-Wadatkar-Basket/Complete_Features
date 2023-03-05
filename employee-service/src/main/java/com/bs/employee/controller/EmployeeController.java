package com.bs.employee.controller;

import com.bs.employee.beans.Employee;
import com.bs.employee.service.EmployeeService;
import com.bs.employee.service.MultithreadedService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private MultithreadedService multithreadedService ;

    @GetMapping("/get")
    public List<Employee> getAllEmployees() throws InterruptedException {
        return multithreadedService.getAllEmployees();
    }
    
    @GetMapping("/getThread")
    public List<Employee> getThread() throws InterruptedException {
        return multithreadedService.getAllEmployeesMultithread();
    }
    
    
    @GetMapping("/update")
    public void updateEmployees() throws InterruptedException {
         multithreadedService.updateEmployee();
    }

    @GetMapping("/updateThread")
    public void updateThread() throws InterruptedException {
    	 multithreadedService.updateEmployeeByThreads();
    }

//    @PostMapping("/update")
//    public Employee updateEmployee(@RequestBody Employee employee) {
//        return employeeService.updateEmployee(employee);
//    }

    @GetMapping("/getByID/{id}")
    public Employee getByID(@PathVariable("id") Integer id) {
        return employeeService.getByID(id);
    }

    @GetMapping("/deleteByID/{id}")
    public String deleteByID(@PathVariable("id") Integer id) {
        return employeeService.deleteEmployeeByID(id);
    }




}
