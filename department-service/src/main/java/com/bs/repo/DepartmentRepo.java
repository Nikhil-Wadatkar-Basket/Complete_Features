package com.bs.repo;

import com.bs.beans.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Repository
public class DepartmentRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    //RowMapper code
    public List<Department> getAllDepartmentsByRowMapper(){
        return jdbcTemplate.query("select * from Department", new RowMapper<Department>() {
            @Override
            public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Department(rs.getInt(1), rs.getInt(3), rs.getString(2), rs.getInt(4));
            }
        });
    }
    // ResultsetExtractor
    public List<Department> getAllDepartmentsByResultSetExtractor() {

        String sqlQuery = "select * from department";
        List<Department> departmentList = jdbcTemplate.query(sqlQuery, new ResultSetExtractor<List<Department>>() {
            @Override
            public List<Department> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Department> departments = new LinkedList<>();
                while (rs.next()) {
                    departments.add(new Department(rs.getInt(1), rs.getInt(3), rs.getString(2), rs.getInt(4)));
                }
                return departments;
            }
        });
        System.out.println(departmentList);
        return departmentList;
    }

    //JDBC Template without parameters
    public Department createDepartmentByCoding(Department department) {
        //   Insert into department (ID,NAME,MONTHLY_BUDGET,LAST_EMPLOYEE_ID) values (1,'ACCOUNTING',20000,8);
        int id = department.getId();
        int monthlyBudget = department.getMonthlyBudget();
        String name = department.getName();
        int last = department.getLastEmployeeId();
        String sqlQuery = "Insert into department (ID,NAME,MONTHLY_BUDGET,LAST_EMPLOYEE_ID) values (" + id + ",'" + name + "'," + monthlyBudget + "," + last + ")";
        System.out.println(sqlQuery);
        int update = jdbcTemplate.update(sqlQuery);
        System.out.println(update);
        return null;
    }

    // PreparedStatementCallback
    public Department createDepartmentByPreparedStatementCallback(Department department) {
        int id = department.getId();
        int monthlyBudget = department.getMonthlyBudget();
        String name = department.getName();
        int last = department.getLastEmployeeId();
        String sqlQuery = "Insert into department (ID,NAME,MONTHLY_BUDGET,LAST_EMPLOYEE_ID) values (?,?,?,?)";
        System.out.println(sqlQuery);
        Object execute = jdbcTemplate.execute(sqlQuery, new PreparedStatementCallback<Object>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setInt(1, department.getId());
                ps.setString(2, department.getName());
                ps.setInt(3, monthlyBudget);
                ps.setInt(4, department.getLastEmployeeId());
                return ps.execute();
            }
        });
        return null;
    }

    public void createDepartmentByNamedParamaeterJdbcTemplate(Department department) {
        int id = department.getId();
        int monthlyBudget = department.getMonthlyBudget();
        String name = department.getName();
        int last = department.getLastEmployeeId();
        String sqlQuery = "Insert into department (ID,NAME,MONTHLY_BUDGET,LAST_EMPLOYEE_ID) values (:id,:name,:monthlyBudget,:lastEmployeeId)";
        System.out.println(sqlQuery);

        //setting parameters using map collection
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("monthlyBudget", monthlyBudget);
        map.put("lastEmployeeId", last);

        Object execute = namedParameterJdbcTemplate.execute(sqlQuery, map, new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });
    }

    public Department updateDepartment(Department department) {

        return null;
    }

    public Department getByID(Integer id) {

        return null;
    }

    public String deleteDepartmentByID(Integer id) {

        String message = null;
        return message;
    }

    public List<Object[]> getDepartmentwiseDepartment() {

        return null;
    }

}