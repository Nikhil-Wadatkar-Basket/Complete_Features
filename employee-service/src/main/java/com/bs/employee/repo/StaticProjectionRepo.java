//package com.bs.employee.repo;
//
//import com.bs.employee.beans.Employee;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface StaticProjectionRepo extends JpaRepository<Employee, Integer> {
//
//    //Get employee id, name and his salary based on id.
//    @Query(value = "select id, name, salary from employee where id=:empID", nativeQuery = true)
//    public List<MyView> getAllEmployee_StaticProjection(@Param("empID") int id);
//}
//
