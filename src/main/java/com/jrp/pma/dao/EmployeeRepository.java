package com.jrp.pma.dao;

import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.entities.Employee;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

//@Profile("prod")
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    @Override
    List<Employee> findAll();

    @Query(nativeQuery = true, value = "SELECT e.first_name AS firstName, e.last_name AS lastName, "+
            "e.email as email, COUNT(pe.employee_id) AS projectCount " +
            "FROM " +
            "EMPLOYEE e LEFT JOIN PROJECT_EMPLOYEE pe ON e.EMPLOYEE_ID  = pe.EMPLOYEE_ID " +
            "GROUP BY  e.first_name, e.last_name, e.email " +
            "ORDER BY 3 DESC ")

    List<EmployeeProject> employeeProjects();

    @Override
    Optional<Employee> findById(Long aLong);

    @Override
    void deleteById(Long aLong);

    Employee findByEmail(String value);
}
