//package com.bs.employee.controller;
//
//import com.bs.employee.beans.Employee;
//import com.bs.employee.repo.DynamicProjection;
//import com.bs.employee.repo.EmployeeCustomQueryRepo;
//import com.bs.employee.repo.MyView;
//import com.bs.employee.repo.StaticProjectionRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class AdvanceEmployeeController {
//    @Autowired
//    private EmployeeCustomQueryRepo repo;
//
//    @Autowired
//    private DynamicProjection dynamicProjection;
//    @Autowired
//    private StaticProjectionRepo staticProjectionRepo;
//
//    @GetMapping("/customQuery")
//    public List<Employee> getDepartmentwiseEmployee() {
//        System.out.println("==========>>>>>>>>>>>>>>>");
//        List<Employee> allEmployee = repo.getAllEmployee();
//        System.out.println(allEmployee);
//        List<String> acAccount1 = repo.getEmployeeByNamePositionParameter("AC_ACCOUNT");
//        System.out.println(acAccount1);
//        List<String> acAccount2 = repo.getEmployeeByNameByNamedParameter("AC_ACCOUNT");
//        System.out.println(acAccount2);
//
//        List<Object[]> acAccount3 = repo.getEmployeeNameAndID("AC_ACCOUNT");
//        acAccount3.forEach(obj -> {
//            for (int i = 0; i < obj.length; i++) {
//                System.out.println(obj[0] + "   " + obj[1]);
//            }
//        });
//        System.out.println("<<<<<<<<<================");
//        return allEmployee;
//    }
//
//
//    @GetMapping("/nativeQuery")
//    public List<Employee> getnativeQuery() {
//        System.out.println("==========>>>>>>>>>>>>>>>");
//        List<Employee> allEmployee = repo.getAllEmployee_NativeSQL();
//        System.out.println(allEmployee);
//        List<String> acAccount1 = repo.getEmployeeByNamePositionParameter_NativeSQL("AC_ACCOUNT");
//        System.out.println(acAccount1);
//        List<String> acAccount2 = repo.getEmployeeByNameByNamedParameter_NativeSQL("AC_ACCOUNT");
//        System.out.println(acAccount2);
//
//        List<Object[]> acAccount3 = repo.getEmployeeNameAndID_NativeSQL("AC_ACCOUNT");
//        acAccount3.forEach(obj -> {
//            for (int i = 0; i < obj.length; i++) {
//                System.out.println(obj[0] + "   " + obj[1]);
//            }
//        });
//        System.out.println("<<<<<<<<<================");
//        return allEmployee;
//    }
//
//    @GetMapping("/nonSelectCustomQuery")
//    public List<Employee> nonSelectCustomQuery() {
//        System.out.println("==========nonSelectCustomQuery>>>>>>>>>>>>>>>");
//        repo.updateEmpoloyeeNameByID("Dhanu", 1);
//        System.out.println("<<<<<<<<<================");
//        List<MyView> allEmployeeStaticProjection = staticProjectionRepo.getAllEmployee_StaticProjection(1);
//        System.out.println(allEmployeeStaticProjection.get(0).getSalary());
//
//        List<Class<MyView>> acAccount = dynamicProjection.findByEmail("AC_ACCOUNT", MyView.class);
//        acAccount.stream().forEach(emp->emp.getName());
//
//        return repo.getAllEmployee();
//    }
//
//
//}
