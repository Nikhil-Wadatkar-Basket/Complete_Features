package com.bs.identificationservice;

import com.bs.identificationservice.beans.Employee;
import com.bs.identificationservice.beans.IdentityDetails;
import com.bs.identificationservice.repo.EmployeeIdentityRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.LinkedHashSet;
import java.util.Set;

@SpringBootApplication
public class IdentificationServiceApplication implements CommandLineRunner {
@Autowired
private EmployeeIdentityRep repo;
    public static void main(String[] args) {
        SpringApplication.run(IdentificationServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        repo.deleteAll();
        System.out.println("IdentificationServiceApplication.run");
        Set<IdentityDetails> identityDetailsSet = new LinkedHashSet<>();

        Employee employee1 = new Employee();
        System.out.println("creating children");
		//creating children
        IdentityDetails identityDetails1 = new IdentityDetails();
        identityDetails1.setVerificationID(10);
        identityDetails1.setVerificationType("Voter ID");
        IdentityDetails identityDetails2 = new IdentityDetails();
        identityDetails2.setVerificationID(20);
        identityDetails2.setVerificationType("Adhar Card");
        IdentityDetails identityDetails3 = new IdentityDetails();
        identityDetails3.setVerificationID(30);
        identityDetails3.setVerificationType("Pan Card");
        System.out.println("setting children to parent");
		//setting children to parent
        identityDetailsSet.add(identityDetails1);
        identityDetailsSet.add(identityDetails2);
        identityDetailsSet.add(identityDetails3);
        employee1.setIdentityDetailsList(identityDetailsSet);
		employee1.setName("Ankur");
		employee1.setEmp_id(12);

        System.out.println("saving employee to DB");
        repo.save(employee1);
        System.out.println("saved completed");
    }
}
