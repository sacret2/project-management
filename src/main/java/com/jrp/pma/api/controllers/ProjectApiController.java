package com.jrp.pma.api.controllers;

import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("app-api/projects")
public class ProjectApiController {
    @Autowired
    ProjectRepository proRepo;

    @GetMapping
    public Iterable<Project> getProjects(){
        return proRepo.findAll();
    }

    @GetMapping(path = "/{id}")
    public Project getProject(@PathVariable("id") Long id){
        return proRepo.findById(id).get();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Project create (@RequestBody @Valid Project project){
        return proRepo.save(project);
    }

    @PutMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Project updatePut (@RequestBody @Valid Project project){
        return proRepo.save(project);
    }

    @PatchMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Project update (@RequestBody @Valid Project project){
        return proRepo.save(project);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        try{
            proRepo.deleteById(id);
        } catch (EmptyResultDataAccessException emptyResExc){

        }
    }
}
