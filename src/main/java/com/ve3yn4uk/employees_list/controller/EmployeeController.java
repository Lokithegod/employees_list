package com.ve3yn4uk.employees_list.controller;

import com.ve3yn4uk.employees_list.entity.Employee;
import com.ve3yn4uk.employees_list.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private IEmployeeService employeeService;

    @Autowired
    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * this endpoint shows list of all employees
     */
    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        List<Employee> employees = employeeService.findAll();
        theModel.addAttribute("employees", employees);

        return "employees/list-employees";
    }

    /**
     * form for adding new employee
     */
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        Employee theEmployee = new Employee();
        theModel.addAttribute("employee", theEmployee);

        return "employees/employee-form";
    }

    /**
     * form for updating an existing employee
     */
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {

        Employee theEmployee = employeeService.findById(theId);
        theModel.addAttribute("employee", theEmployee);

        return "employees/employee-form";
    }

    /**
     * for saving/updating employee to db
     */
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {

        employeeService.saveOrUpdate(theEmployee);

        return "redirect:/employees/list";
    }

    /**
     * for removing employee from db
     */
    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int theId) {

        employeeService.deleteById(theId);

        return "redirect:/employees/list";
    }

    /**
     * enpdoint for showing employees from current project & employees without progect
     */
    @GetMapping("/listProject")
    public String listEmployeesOnProject(@RequestParam("projectId") int theId, Model theModel) {

        List<Employee> employeesOnProject = employeeService.findByProjectId(theId);
        theModel.addAttribute("employees", employeesOnProject);

        List<Employee> employeesWithoutProject = employeeService.findByProjectId(0);
        theModel.addAttribute("freeEmployees", employeesWithoutProject);

        theModel.addAttribute("project", theId);

        return "employees/list-onProject";
    }

    /**
     * removes employee from the project (not from db)
     */
    @GetMapping("/remove")
    public String removeEmployee(@RequestParam("employeeId") int theId, @RequestParam("projectId") int projectId) {

        Employee theEmployee = employeeService.findById(theId);
        theEmployee.setProjectId(0);
        employeeService.saveOrUpdate(theEmployee);

        return "redirect:/employees/listProject?projectId=" + projectId;
    }

    /**
     * adds employee to the project
     */
    @GetMapping("/hire")
    public String hireEmployee(@RequestParam("employeeId") int theId, @RequestParam("projectId") int projectId) {

        Employee theEmployee = employeeService.findById(theId);
        theEmployee.setProjectId(projectId);
        employeeService.saveOrUpdate(theEmployee);

        return "redirect:/employees/listProject?projectId=" + projectId;
    }
}
