package com.bs.service;

import com.bs.beans.Department;
import com.bs.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepo repo;

    public List<Department> getAllDepartmentsByResultSetExtractor() {
        return repo.getAllDepartmentsByResultSetExtractor();
    }
    public List<Department> getAllDepartmentsByRowMapper() {
        return repo.getAllDepartmentsByRowMapper();
    }

    public Department createDepartmentByCoding(Department department) {
        return repo.createDepartmentByCoding(department);
    }
    public Department createDepartmentByPreparedStatementCallback(Department department) {
        return repo.createDepartmentByPreparedStatementCallback(department);
    }

    public void createDepartmentByNamedParamaeterJdbcTemplate(Department department) {
         repo.createDepartmentByNamedParamaeterJdbcTemplate(department);
    }

    public Department updateDepartment(Department department) {
        return repo.updateDepartment(department);
    }

    public Department getByID(Integer id) {

        return repo.getByID(id);
    }

    public String deleteDepartmentByID(Integer id) {
        return repo.deleteDepartmentByID(id);
    }

    public List<Object[]> getDepartmentwiseDepartment() {
        return repo.getDepartmentwiseDepartment();
    }
}
