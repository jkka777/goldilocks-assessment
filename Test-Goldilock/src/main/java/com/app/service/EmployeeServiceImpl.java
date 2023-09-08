package com.app.service;

import com.app.exceptions.EmployeeException;
import com.app.model.Employee;
import com.app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(int id) throws EmployeeException {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) return optionalEmployee.get();
        throw new EmployeeException("Employee not found with id: " + id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getEmployeeByAgeLessThanAndNameStartsWith(Integer age, String name) {
        return employeeRepository.getEmpByAgeAndLetter(age, name);
    }

    @Override
    public Map<String, Integer> getEmployeeDetails(Integer age) {

        Map<String, Integer> dataMap = new HashMap<>();
        List<Employee> employees = employeeRepository.findAll();
        for (Employee e : employees) dataMap.put(e.getEmployeeName(), e.getEmployeeAge());

        Map<String, Integer> resultMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : dataMap.entrySet()) {
            if (entry.getValue().equals(age)) resultMap.put(entry.getKey(), entry.getValue());
        }
        return resultMap;
    }
}
