package com.ve3yn4uk.employees_list;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication
public class EmployeesListApplication extends WebMvcConfigurationSupport {

    public static void main(String[] args)  {
        SpringApplication.run(EmployeesListApplication.class, args);
    }

}
