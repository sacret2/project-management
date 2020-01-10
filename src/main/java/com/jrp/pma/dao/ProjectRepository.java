package com.jrp.pma.dao;

import com.jrp.pma.dto.ProjectStageCount;
import com.jrp.pma.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    @Override
    List<Project> findAll();

    @Query(nativeQuery = true, value = "SELECT project.stage as projectStage, COUNT(*) as projectCount FROM project " +
            "GROUP BY project.STAGE ")
    List<ProjectStageCount> getProjectCountsByStage();
}
