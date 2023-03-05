package com.bs.employee;

import com.bs.employee.repo.EmployeeCustomQueryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeServiceApplication implements CommandLineRunner {

    @Autowired
    private EmployeeCustomQueryRepo repo;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

    }
}
