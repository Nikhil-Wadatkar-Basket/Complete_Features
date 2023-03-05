package com.bs.employee.service;

import com.bs.employee.beans.Employee;
import com.bs.employee.beans.IDepartmentWiseCount;
import com.bs.employee.exception.EmployeeNotFoundException;
import com.bs.employee.exception.EmptyEmployeeList;
import com.bs.employee.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo repo;

    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = repo.findAll();
        if (employeeList.size() == 0)
            throw new EmptyEmployeeList("Employee list is empty");
        return employeeList;
    }

    public Employee createEmployee(Employee employee) {
        return repo.save(employee);
    }

//    public Employee updateEmployee(Employee employee) {
//        Employee updatedEmployee = null;
//        Optional<Employee> existedEmployee = repo.findById(employee.getId());
//        if (existedEmployee.isPresent()) {
//            Employee newEmployee = new Employee();
//            newEmployee.setBirthdate(existedEmployee.get().getBirthdate());
//            newEmployee.setEmail(existedEmployee.get().getEmail());
//            newEmployee.setHire_date(existedEmployee.get().getHire_date());
//            newEmployee.setName(existedEmployee.get().getName());
//            newEmployee.setPhone(existedEmployee.get().getPhone());
//            newEmployee.setSalary(existedEmployee.get().getSalary());
//            newEmployee.setDepartment_id(existedEmployee.get().getDepartment_id());
//            newEmployee.setJob_id(existedEmployee.get().getJob_id());
//            updatedEmployee = repo.save(newEmployee);
//        }
//        return updatedEmployee;
//    }

    public Employee getByID(Integer id) {
        Optional<Employee> employeeOptional = repo.findById(id);
        Employee existedEmployee = null;
        if (employeeOptional.isPresent())
            existedEmployee = employeeOptional.get();
        else
            throw new EmployeeNotFoundException("Employee Not there");
        return existedEmployee;
    }

    public String deleteEmployeeByID(Integer id) {
        Optional<Employee> employeeOptional = repo.findById(id);
        String message = null;
        if (employeeOptional.isPresent()) {
            repo.deleteById(id);
            message = "Employee deleted";
        } else {
            throw new EmployeeNotFoundException("Employee Not there");
        }
        return message;
    }

//    public  List<Object[]> getDepartmentwiseEmployee() {
//        Map<Integer, Integer> employeeList = null;
//        List<Object[]> departmentwiseEmployee = repo.getDepartmentwiseEmployee();
//
//        List<IDepartmentWiseCount> iDepartmentWiseCounts = repo.countTotalCommentsByYearInterface();
//        System.out.println("==========================");
//        iDepartmentWiseCounts.stream().forEach(emp->{
//            System.out.println(emp.getDeptID()+" "+emp.getTotalCount());
//        });
//        System.out.println("==========================");
////        Optional<Map<String, Integer>> employeeOptional = ofNullable(repo.getDepartmentwiseEmployee());
//
////        if (employeeOptional.isPresent()) {
////            employeeList = employeeOptional.get();
////
////        } else {
////            throw new EmptyEmployeeList("Employee Not there");
////        }
//        return departmentwiseEmployee;
//    }
}
