package com.ve3yn4uk.employees_list.service;

import com.ve3yn4uk.employees_list.entity.Project;
import com.ve3yn4uk.employees_list.repository.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements IProjectService {

    private IProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project findById(int theId) {

        Optional<Project> result = projectRepository.findById(theId);

        Project theProject = null;

        if (result.isPresent()) {
            theProject = result.get();
        } else {
            throw new RuntimeException("Did not find the project id " + theId);
        }

        return theProject;
    }

    @Override
    public void saveOrUpdate(Project theEmployee) {
        projectRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        projectRepository.deleteById(theId);
    }
}
