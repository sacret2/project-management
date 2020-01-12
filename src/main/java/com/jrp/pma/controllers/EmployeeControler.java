package com.jrp.pma.controllers;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.entities.Employee;
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
public class EmployeeControler {

    @Autowired
    EmployeeRepository employeeRepo;

    /* // constructor injection (without @Autowired)
    public EmployeeControler(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
     */
    /* // setter injection (needs @Autowired)
    @Autowired
    public setEmployeeRepo (EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
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
        employeeRepo.save(employee);
        return "redirect:/employees/new";
    }

    @GetMapping("")
    public String displayEmployeeList(Model model){
        List<Employee> employees = employeeRepo.findAll();
        model.addAttribute("employeeList", employees);
        return "employees/list-employees";
    }

    @GetMapping("/remove")
    public String displayEmployeeList(@RequestParam ("employeeId") long employeeId){
        employeeRepo.deleteById(employeeId);
        return "redirect:/employees/";
    }
}
