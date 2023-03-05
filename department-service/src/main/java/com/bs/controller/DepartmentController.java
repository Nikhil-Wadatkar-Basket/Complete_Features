package com.bs.controller;

import com.bs.beans.Department;
import com.bs.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/getByRowmapper")
    public List<Department> getAllDepartmentsByRowMapper() {
        return departmentService.getAllDepartmentsByRowMapper();
    }
    @GetMapping("/get")
    public List<Department> getAllDepartmentsByResultsetExtractor() {
        return departmentService.getAllDepartmentsByResultSetExtractor();
    }

//    @PostMapping("/create")
    @RequestMapping(path = "/create",consumes = "application/json",produces = "application/xml")
    public List<Department> createDepartment(@RequestBody Department department) {
//        departmentService.createDepartmentByCoding(department);
//        departmentService.createDepartmentByPreparedStatementCallback(department);
        departmentService.createDepartmentByNamedParamaeterJdbcTemplate(department);
        return getAllDepartmentsByRowMapper();
    }

    @PostMapping("/update")
    public Department updateDepartment(@RequestBody Department department) {
        return departmentService.updateDepartment(department);
    }

    @GetMapping("/getByID/{id}")
    public Department getByID(@PathVariable("id") Integer id) {
        return departmentService.getByID(id);
    }

    @GetMapping("/deleteByID/{id}")
    public String deleteByID(@PathVariable("id") Integer id) {
        return departmentService.deleteDepartmentByID(id);
    }




}
