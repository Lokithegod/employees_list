package com.ve3yn4uk.employees_list.controller;

import com.ve3yn4uk.employees_list.entity.Project;
import com.ve3yn4uk.employees_list.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private IProjectService projectService;

    @Autowired
    public ProjectController(IProjectService projectService) {
        this.projectService = projectService;
    }

    /**
     * this endpoint shows list of all projects
     */
    @GetMapping("/list")
    public String listProjects(Model theModel) {

        List<Project> projects = projectService.findAll();
        theModel.addAttribute("projects", projects);

        return "projects/list-projects";
    }

    /**
     * form for adding new project
     */
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        Project theProject = new Project();
        theModel.addAttribute("project", theProject);

        return "projects/project-form";
    }

    /**
     * form for updating a existing project
     */
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("projectId") int theId, Model theModel) {

        Project theProject = projectService.findById(theId);
        theModel.addAttribute("project", theProject);

        return "projects/project-form";
    }

    /**
     * for saving/updating project to db
     */
    @PostMapping("/save")
    public String saveProject(@ModelAttribute("project") Project theProject) {

        projectService.saveOrUpdate(theProject);

        return "redirect:/projects/list";
    }

    /**
     * for removing project from db
     */
    @GetMapping("/delete")
    public String deleteProject(@RequestParam("projectId") int theId) {

        projectService.deleteById(theId);

        return "redirect:/projects/list";
    }
}
