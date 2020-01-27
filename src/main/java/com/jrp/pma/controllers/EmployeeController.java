package com.jrp.pma.controllers;

import com.jrp.pma.entities.Employee;
import com.jrp.pma.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService empService;

    //==== View =====
    @GetMapping("")
    public String displayEmployees(Model model, Principal user){
        model.addAttribute("loggedin", user != null);
        List<Employee> employees = empService.findAll();
        model.addAttribute("employeeList", employees);
        return "employees/list-employees";
    }

    @GetMapping("/view")
    public String displayProject(@RequestParam("id") Long employeeId, Model model, Principal user){
        model.addAttribute("loggedin", user != null);
        Employee employee = empService.findById(employeeId);
        model.addAttribute("employee", employee);
        model.addAttribute("projectList", employee.getProjects());
        return "employees/employee";
    }
    //==== View ===== end

    //==== Forms =====
    @GetMapping("/new")
    public String newEmployee(Model model, Principal user){
        model.addAttribute("loggedin", user != null);
        Employee anEmployee = new Employee();
        model.addAttribute("employee", anEmployee);
        return "employees/new-employee";
    }
    //==== Forms ===== end

    //==== CRUD =====
    @PostMapping(value = "/save")
    public String saveEmployee(Model model, Employee employee, RedirectAttributes redirectAttributes){
        empService.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/delete")
    public String displayEmployeeList(@RequestParam ("id") long employeeId){
        empService.deleteById(employeeId);
        return "redirect:/employees/";
    }
    //==== CRUD ===== end
}
