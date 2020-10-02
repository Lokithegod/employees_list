package com.ve3yn4uk.employees_list.service;

import com.ve3yn4uk.employees_list.entity.Employee;

import java.util.List;

public interface IEmployeeService {

    /**
     * returns a list of all employees
     */
    List<Employee> findAll();

    /**
     * returns an employee by id
     */
    Employee findById(int theId);

    /**
     * saves or updates employee
     */
    void saveOrUpdate(Employee theEmployee);

    /**
     * delets an employee by id
     */
    void deleteById(int theId);

    /**
     * returns a list of employees from a project
     */
    List<Employee> findByProjectId(int theId);


}

