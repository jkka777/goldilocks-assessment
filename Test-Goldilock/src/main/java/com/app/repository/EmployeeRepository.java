package com.app.repository;

import com.app.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("select e from com.app.model.Employee e where e.employeeAge <= ?1 and e.employeeName like ?2%")
    List<Employee> getEmpByAgeAndLetter(Integer age, String letter);
}
