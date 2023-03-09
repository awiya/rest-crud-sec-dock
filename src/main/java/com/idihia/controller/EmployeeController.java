package com.idihia.controller;

import com.idihia.errors.EmployeeNotFoundException;
import com.idihia.model.Employee;
import com.idihia.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/***
 * this class plays the role of the controller of the Employee entity
 * @author Ayoub ID-IHIA
 *
 */

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    /**
     * this method has the following role: return the complete list of employees
     * @return
     */

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }


    /***
     * this method has for role : return an employee, knowing his id
     * @param id the id of the Employee
     * @return the method returns the employee saved in JSON format
     * @throws EmployeeNotFoundException
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployee(@PathVariable int id) throws EmployeeNotFoundException {
        return employeeService.getEmployee(id);
    }

    // add a simple employee with a JSON format
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody @Valid Employee employee) {
        return employeeService.addEmployee(employee);
    }

    // update the data of an employee knowing his id
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee updateEmployee(@RequestBody @Valid Employee employee, @PathVariable Integer id) throws EmployeeNotFoundException {
        return employeeService.updateEmployee(employee, id);
    }


    // delete an employee from the database knowing its id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean deleteEmployee(@PathVariable int id) {
        return employeeService.deleteEmployee(id);
    }

}