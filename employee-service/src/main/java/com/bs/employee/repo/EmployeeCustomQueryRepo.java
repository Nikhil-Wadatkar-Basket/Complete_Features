package com.bs.employee.repo;

import com.bs.employee.beans.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmployeeCustomQueryRepo extends JpaRepository<Employee, Integer> {

//    =====================HQL/JPQL=================================
//    =============================================================
//    ----------------------Select queries------------------------
//    =============================================================

    //    List<T>
//    @Query(value = "from Employee e")
//    public List<Employee> getAllEmployee();
//
//    //    List<String>
//    @Query(value = "select e.name from Employee e where e.job_id like ?1")
//    public List<String> getEmployeeByNamePositionParameter(String name);
//
//    //    List<String>
//    @Query(value = "select e.name from Employee e where e.job_id like :job_id")
//    public List<String> getEmployeeByNameByNamedParameter(@Param("job_id") String job_id);
//
//
//    @Query(value = "select e.id, e.name from Employee e where e.job_id like :job_id")
//    public List<Object[]> getEmployeeNameAndID(@Param("job_id") String job_id);
//
//    //====================Native SQL=============================
//    @Query(value = "select * from employee", nativeQuery = true)
//    public List<Employee> getAllEmployee_NativeSQL();
//
//    //    List<String>
//    @Query(value = "select name from Employee e where e.job_id like ?1", nativeQuery = true)
//    public List<String> getEmployeeByNamePositionParameter_NativeSQL(String name);
//
//    //    List<String>
//    @Query(value = "select name from Employee e where e.job_id like :job_id", nativeQuery = true)
//    public List<String> getEmployeeByNameByNamedParameter_NativeSQL(@Param("job_id") String job_id);
//
//
//    @Query(value = "select id, name from Employee  where job_id like :job_id", nativeQuery = true)
//    public List<Object[]> getEmployeeNameAndID_NativeSQL(@Param("job_id") String job_id);
////    ===============================================================
////    --------------------  Non - Select queries  -------------------
////    ===============================================================
////    ===============================================================
////    ================>>>>>>>>> HQL methods <<<<<<<<<<===============
////    ===============================================================
//
//    @Query(value = "update Employee set name = ?1 where id=?2")
//    @Modifying
//    @Transactional
//    public void updateEmpoloyeeNameByID(String myName,Integer id);
}