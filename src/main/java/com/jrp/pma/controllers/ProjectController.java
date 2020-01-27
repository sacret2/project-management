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

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectService proService;

    @Autowired
    EmployeeService empService;

    //==== View =====
    @GetMapping("/")
    public String displayProjects(Model model, Principal user){
        model.addAttribute("loggedin", user != null);
        List<Project> projectList = proService.findAll();
        model.addAttribute("projectList", projectList);
        return "projects/list-projects";
    }

    @GetMapping("/view")
    public String displayProject(@RequestParam("id") Long projectId, Model model, Principal user){
        model.addAttribute("loggedin", user != null);
        Project project = proService.findById(projectId);
        model.addAttribute("project", project);
        model.addAttribute("employeeList", project.getEmployees());
        return "projects/project";
    }
    //==== View ===== end

    //==== Forms =====
    @GetMapping("/new")
    public String displayProjectForm(Model model, Principal user){
        model.addAttribute("loggedin", user != null);
        Project aProject = new Project();
        Iterable<Employee> employees = empService.findAll();
        model.addAttribute("project", aProject);
        model.addAttribute("allEmployees", employees);
        return "projects/new-project";
    }
    //==== Forms ===== end

    //==== CRUD =====
    @PostMapping(value = "/save")
    public String createProject(Project project, @RequestParam List<Long> employees, Model model ) {
        proService.save(project);
        return "redirect:/projects/";
    }

    @GetMapping("/delete")
    public String removeProject(@RequestParam("id") Long id){
        proService.deleteById(id);
        return "redirect:/projects/";
    }
    //==== CRUD ===== end


}
