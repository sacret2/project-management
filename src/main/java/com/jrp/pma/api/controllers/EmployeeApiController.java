package com.jrp.pma.api.controllers;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/app-api/employees")
public class EmployeeApiController {
    @Autowired
    EmployeeRepository empRepo;

    @GetMapping
    public Iterable<Employee> getEmployees(){
        return empRepo.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id){
        return empRepo.findById(id).get();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody Employee employee){
        return empRepo.save(employee);
    }

    @PutMapping(path = "/{id}", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Employee update(@RequestBody Employee employee){
        return empRepo.save(employee);
    }

    @PatchMapping(consumes = "application/json")
    public Employee partialUpdate(@PathVariable("id") long id, @RequestBody Employee patchEmployee){
        Employee emp = empRepo.findById(id).get();
        if(patchEmployee.getEmail() != null){
            emp.setEmail(patchEmployee.getEmail());
        }
        if(patchEmployee.getFirstName() != null){
            emp.setFirstName(patchEmployee.getFirstName());
        }
        if(patchEmployee.getLastName() != null){
            emp.setLastName(patchEmployee.getLastName());
        }
        return empRepo.save(emp);
    }
}