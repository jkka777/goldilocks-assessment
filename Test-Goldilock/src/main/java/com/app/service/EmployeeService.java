package com.app.service;

import com.app.exceptions.EmployeeException;
import com.app.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    public Employee saveEmployee(Employee employee);

    public Employee getEmployeeById(int id) throws EmployeeException;

    public List<Employee> getAllEmployees();

    public List<Employee> getEmployeeByAgeLessThanAndNameStartsWith(Integer age, String name);

    public Map<String, Integer> getEmployeeDetails(Integer age);
}
