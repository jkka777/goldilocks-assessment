package com.app.controller;

import com.app.exceptions.EmployeeException;
import com.app.model.Employee;
import com.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class EmployeeController {

    @Autowired
    private EmployeeService es;

    // method to get employee details from DB based on value id i.e., primary key id in DB
    @GetMapping("/getById")
    public ResponseEntity<Employee> getEmployee(@RequestParam String value) throws EmployeeException {
        int val = Integer.parseInt(value);
        return new ResponseEntity<>(es.getEmployeeById(val), HttpStatus.OK);
    }

    // method to save employee details to DB
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestParam String name, @RequestParam String age) {
        int val = Integer.parseInt(age);
        Employee employee = new Employee(name, val);
        es.saveEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    // method to get all employee details
    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = es.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // method to get employee list by age less than and name starts with conditions
    @GetMapping("/get")
    public ResponseEntity<List<Employee>> getEmployeeByAgeLessThanAndEmployeeNameStartsWith(@RequestParam String age, @RequestParam String letter) {
        int val = Integer.parseInt(age);
        List<Employee> employees = es.getEmployeeByAgeLessThanAndNameStartsWith(val, letter);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // method to get employees details by age, using hashmap
    @GetMapping
    public ResponseEntity<Map<String, Integer>> getEmployeeDetails(@RequestParam String value) {
        int val = Integer.parseInt(value);
        Map<String, Integer> map = es.getEmployeeDetails(val);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }


}
