package org.lk.employee_crud.model;


public class Employee {

    int empId;
    String empName;

    public int getEmpId() {
        return empId;
    }

    public Employee(int empId, String empName, String department) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    String department;
}
