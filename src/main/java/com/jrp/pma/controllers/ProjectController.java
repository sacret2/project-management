package com.jrp.pma.controllers;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.MyEntityRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepository empRepo;

    @Autowired
    MyEntityRepository myEntityRepo;

    @GetMapping("/new")
    public String displayProjectForm(Model model){
        Project aProject = new Project();
        List<Employee> employees = empRepo.findAll();
        model.addAttribute("project", aProject);
        model.addAttribute("allEmployees", employees);
        return "projects/new-project";
    }

    @PostMapping(value = "/save")   // CZEMU brak @RequestParam (bo jest już w modelu?)
    public String createProject(Project project, @RequestParam List<Long> employees, Model model ) { //, RedirectAttributes redirectAttributes){
        proRepo.save(project);

        //dont have to do it anymore, persists, refreshes
//        Iterable<Employee> chosenEmployees = empRepo.findAllById(employees);
//
//        for(Employee employee : chosenEmployees){
//            employee.getProjects().add(project);
//            empRepo.save(employee);
//        }

        //redirectAttributes.addFlashAttribute("project", project);
//        MyEntity myEntity = new MyEntity(project);
//        myEntityRepo.save(myEntity);
        return "redirect:/projects/";
    }

    @GetMapping("/")
    public String displayProjects(Model model){
        List<Project> projectList = proRepo.findAll();
        model.addAttribute("projectList", projectList);
        return "projects/list-projects";
    }
}
