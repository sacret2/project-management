package com.jrp.pma.dao;

import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    @Override
    List<Employee> findAll();

    @Query(nativeQuery = true, value = "SELECT e.first_name AS firstName, e.last_name AS lastName, "+
            "e.email as email, COUNT(pe.employee_id) AS projectCount " +
            "FROM " +
            "EMPLOYEE e LEFT JOIN PROJECT_EMPLOYEE pe ON e.EMPLOYEE_ID  = pe.EMPLOYEE_ID " +
            "GROUP BY  e.first_name, e.last_name " +
            "ORDER BY 3 DESC ")
    public List<EmployeeProject> employeeProjects();
}
