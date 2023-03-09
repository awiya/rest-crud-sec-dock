package com.idihia.service;

import com.idihia.errors.EmployeeNotFoundException;
import com.idihia.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();

    Employee getEmployee(int id) throws EmployeeNotFoundException;

    Employee addEmployee(Employee employee);

    Employee updateEmployee(Employee employee, Integer id) throws EmployeeNotFoundException;

    Boolean deleteEmployee(int id);
}
