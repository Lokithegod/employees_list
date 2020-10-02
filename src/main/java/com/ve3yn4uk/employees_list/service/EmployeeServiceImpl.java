package com.ve3yn4uk.employees_list.service;

import com.ve3yn4uk.employees_list.entity.Employee;
import com.ve3yn4uk.employees_list.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private IEmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(IEmployeeRepository EmployeeRepository) {
        this.employeeRepository = EmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {

        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            throw new RuntimeException("Did not find the employee id " + theId);
        }

        return theEmployee;
    }

    @Override
    public void saveOrUpdate(Employee theEmployee) {
        employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }

    @Override
    public List<Employee> findByProjectId(int theId) {
        return employeeRepository.findByProjectId(theId);
    }
}
