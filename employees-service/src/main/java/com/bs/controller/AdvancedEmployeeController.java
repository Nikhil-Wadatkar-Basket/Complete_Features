package com.bs.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bs.beans.Departments;
import com.bs.beans.Employees;
import com.bs.service.EmployeesService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class AdvancedEmployeeController {
//	private static Logger logger = LogManager.getLogger(AdvancedEmployeeController.class);
	@Autowired
	private EmployeesService service;
	static List<Employees> employees = new LinkedList<Employees>();

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/saveAllEmployees")
	public Integer saveAllEmployees(@RequestBody List<Employees> employees) {
//		logger.debug("### AdvancedEmployeeController.saveAllEmployees() start ###");
		Integer employeesCount = service.saveAllEmployees(employees);
//		logger.debug("### Employees count ###" + employeesCount);
//		logger.debug("### AdvancedEmployeeController.saveAllEmployees() end ###");
		return employeesCount;
	}

	@GetMapping("/getEmployees")
	public List<Employees> getEmployees() {
//		logger.debug("### AdvancedEmployeeController.getEmployees() start ###");
		List<Employees> allEmployees = service.getAllEmployees();
		this.employees.addAll(allEmployees);
//		logger.debug("### AdvancedEmployeeController.getEmployees() end ###");
		return allEmployees;
	}

	@GetMapping("/showEmployees")
	public List<Employees> showEmployees() {
		return employees;
	}

	@GetMapping("/saveDeptNames")
	public List<Employees> saveDeptNames() {

		// use restTemplat to call dept service and get dept details
		// call dept service and get all dept details
		Departments[] departments = restTemplate.getForObject("http://localhost:2222/getAll", Departments[].class);
		System.out.println(departments);
		Map<Integer, String> map = Arrays.stream(departments)
				.collect(Collectors.toMap(Departments::getDepartmentId, Departments::getDepartmentName));
		System.out.println(map);

		// get all employees
		List<Employees> employees = service.getAllEmployees();
		System.out.println(employees);
		
		for (Employees emp : employees) {
			
			int id = emp.getDepartmentId();
			boolean isPresent = map.containsKey(id);
			if (isPresent == true) {
				String departmentName = map.get(id);
				emp.setDepartmentName(departmentName);
			}
		}
		return employees;
	}

}
