package com.inclusion.accessibility.repository;

import com.inclusion.accessibility.wcag.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
