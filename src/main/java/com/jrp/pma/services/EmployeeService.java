package com.jrp.pma.services;

import com.jrp.pma.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository empRepo;

    public EmployeeService(EmployeeRepository empRepo) {
        this.empRepo = empRepo;
    }

    @Autowired
    public void setEmpRepo(EmployeeRepository empRepo) {
        this.empRepo = empRepo;
    }
}
