package com.idihia.service;

import com.idihia.errors.EmployeeNotFoundException;
import com.idihia.model.Employee;
import com.idihia.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(int id) throws EmployeeNotFoundException {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(String.format("Employee with the id: %s is not found", id)));
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee, Integer id) throws EmployeeNotFoundException {
        Employee employeeDB = getEmployee(id);
        employeeDB.setFirstname(employee.getFirstname());
        employeeDB.setLastname(employee.getLastname());
        employeeDB.setEmail(employee.getEmail());
        return employeeRepository.save(employeeDB);
    }

    @Override
    public Boolean deleteEmployee(int id) {
        employeeRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
