package com.jrp.pma.controllers;

import com.jrp.pma.dao.MyEntityRepository;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;
import com.jrp.pma.services.EmployeeService;
import com.jrp.pma.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    ProjectService proService;

    @Autowired
    EmployeeService empService;

    @Autowired
    MyEntityRepository myEntityRepo;

    @GetMapping("/new")
    public String displayProjectForm(Model model){
        Project aProject = new Project();
        Iterable<Employee> employees = empService.findAll();
        model.addAttribute("project", aProject);
        model.addAttribute("allEmployees", employees);
        return "projects/new-project";
    }

    @PostMapping(value = "/save")
    public String createProject(Project project, @RequestParam List<Long> employees, Model model ) { //, RedirectAttributes redirectAttributes){
        proService.save(project);

        //dont have to do it anymore, persists, refreshes
//        Iterable<Employee> chosenEmployees = empService.findAllById(employees);
//
//        for(Employee employee : chosenEmployees){
//            employee.getProjects().add(project);
//            empService.save(employee);
//        }

        //redirectAttributes.addFlashAttribute("project", project);
//        MyEntity myEntity = new MyEntity(project);
//        myEntityRepo.save(myEntity);
        return "redirect:/projects/";
    }

    @GetMapping("/")
    public String displayProjects(Model model){
        List<Project> projectList = proService.findAll();
        model.addAttribute("projectList", projectList);
        return "projects/list-projects";
    }
}
