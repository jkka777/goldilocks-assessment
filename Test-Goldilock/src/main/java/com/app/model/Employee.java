package com.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer employeeId;
    private String employeeName;
    private Integer employeeAge;

    public Employee() {
    }

    public Employee(String studentName, Integer studentAge) {
        this.employeeName = studentName;
        this.employeeAge = studentAge;
    }

    public Employee(Integer studentId, String studentName, Integer studentAge) {
        this.employeeId = studentId;
        this.employeeName = studentName;
        this.employeeAge = studentAge;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(Integer employeeAge) {
        this.employeeAge = employeeAge;
    }

    @Override
    public String toString() {
        return "Student {Id= " + employeeId + ", Name='" + employeeName + ", Age=" + employeeAge + "}";
    }
}
