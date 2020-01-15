package com.jrp.pma.services;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository empRepo;

    public Employee save(Employee employee){
        return this.empRepo.save(employee);
    }

    public List<Employee> findAll(){
        return this.empRepo.findAll();
    }

    public List<EmployeeProject> employeeProjects(){
        return this.empRepo.employeeProjects();
    }

    public void deleteById(Long id){
        this.empRepo.deleteById(id);
    }
}
