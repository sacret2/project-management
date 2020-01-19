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

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    /* // constructor injection (without @Autowired)
    public EmployeeController(employeeService employeeService) {
        this.employeeService = employeeService;
    }
     */
    /* // setter injection (needs @Autowired)
    @Autowired
    public setEmployeeService (employeeService employeeService) {
        this.employeeService = employeeService;
    }
     */
    @GetMapping("/new")
    public String newEmployee(Model model){
        Employee anEmployee = new Employee();
        model.addAttribute("employee", anEmployee);
        return "employees/new-employee";
    }

    @PostMapping(value = "/save")
    public String saveEmployee(Model model, Employee employee, RedirectAttributes redirectAttributes){
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("")
    public String displayEmployeeList(Model model){
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employeeList", employees);
        return "employees/list-employees";
    }

    @GetMapping("/remove")
    public String displayEmployeeList(@RequestParam ("employeeId") long employeeId){
        employeeService.deleteById(employeeId);
        return "redirect:/employees/";
    }
}
