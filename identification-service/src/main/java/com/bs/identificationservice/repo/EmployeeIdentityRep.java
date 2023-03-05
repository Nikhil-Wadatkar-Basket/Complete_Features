package com.bs.identificationservice.repo;

import com.bs.identificationservice.beans.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface EmployeeIdentityRep extends JpaRepository<Employee, Integer> {
}
