package com.ve3yn4uk.employees_list.service;

import com.ve3yn4uk.employees_list.entity.Project;

import java.util.List;

public interface IProjectService {

    /**
     * returns a list of all projects
     */
    List<Project> findAll();

    /**
     * returns project by id
     */
    Project findById(int theId);

    /**
     * saves or updates project
     */
    void saveOrUpdate(Project theEmployee);

    /**
     * delets project by id
     */
    void deleteById(int theId);
}
