package com.ve3yn4uk.employees_list.repository;

import com.ve3yn4uk.employees_list.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProjectRepository extends JpaRepository<Project, Integer> {
}
