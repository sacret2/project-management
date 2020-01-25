package com.jrp.pma.services;

import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.dto.ProjectStageCount;
import com.jrp.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository proRepo;

    public List<Project> findAll(){
        return this.proRepo.findAll();
    }

    public List<ProjectStageCount> getProjectCountsByStage(){
        return this.proRepo.getProjectCountsByStage();
    }

    public void save(Project project) {
        this.proRepo.save(project);
    }

    public void deleteById(Long id) {
        this.proRepo.deleteById(id);
    }
}
