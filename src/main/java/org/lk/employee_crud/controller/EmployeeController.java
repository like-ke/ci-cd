package org.lk.employee_crud.controller;

import org.lk.employee_crud.model.Employee;
import org.lk.employee_crud.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;

@RestController
public class EmployeeController {

   // @Autowired
    private final EmployeeRepo employeeRepo;


    public EmployeeController(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @GetMapping("/getEmployee/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeRepo.getEmployee(id);
    }
    @GetMapping("/getAllEmployees")
    public java.util.List<Employee> getAllEmployees() {
        return employeeRepo.getAllEmployees();
    }
    @PostMapping("/SetEmployee")
    public String setEmployee(@RequestBody Employee employee) {



         if( employeeRepo.setEmployee(employee)==1)
             return "success";
         else
             return "failed";

    }
    @PatchMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable int id,@RequestBody String department) {

        if( employeeRepo.updateEmployee(id,department)==1)
            return "success";
        else
            return "failed";
    }

    @DeleteMapping("/deleteEmpolyee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        if( employeeRepo.deleteEmployee(id)==1)
            return "success";
        else
            return "failed";
    }
}
