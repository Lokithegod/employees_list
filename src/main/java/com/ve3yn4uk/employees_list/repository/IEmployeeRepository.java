package com.ve3yn4uk.employees_list.repository;

import com.ve3yn4uk.employees_list.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByProjectId(int theId);


}
