package org.lk.employee_crud.repo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.lk.employee_crud.model.Employee;

import java.util.List;

@Repository
public class EmployeeRepo {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Employee getEmployee(int id){
        String getemployeeSQL = "SELECT * FROM empdata where empid=?";
        return jdbcTemplate.queryForObject(getemployeeSQL,(rs,rowNUm)->
                  new Employee(rs.getInt("empid"),
                          rs.getString("empname"),
                          rs.getString("department")),id

                );
    }
    public List<Employee> getAllEmployees(){
        String getAllEmployeeSQL = "SELECT * FROM empdata";
        return jdbcTemplate.query(getAllEmployeeSQL,(rs,rowNUm)->
                new Employee(rs.getInt("empid"),
                        rs.getString("empname"),
                        rs.getString("department"))
        );
    }



//insert
    public int setEmployee(Employee employee){
        String insertSQL= "INSERT INTO empdata  VALUES(?,?,?)";
        return jdbcTemplate.update(insertSQL,
                employee.getEmpId(),
                employee.getEmpName(),
                employee.getDepartment()
        );
    }
    //update
    public int updateEmployee(int empid,String department){
        String updateSQL= "UPDATE empdata SET  department=? WHERE empid=?";
        return jdbcTemplate.update(updateSQL,department,empid

        );
    }
    //delete
    public int deleteEmployee(int id) {
        String deleteSQL = "DELETE FROM empdata WHERE empid=?";
        return jdbcTemplate.update(deleteSQL, id);
    }

}
