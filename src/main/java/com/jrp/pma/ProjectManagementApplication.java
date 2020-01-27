package com.jrp.pma;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.dao.UserAccountRepository;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;

@SpringBootApplication(scanBasePackages = {"com.jrp.pma"})
public class ProjectManagementApplication {

    @Autowired
    EmployeeRepository empRepo;
    @Autowired
    ProjectRepository projRepo;

    public static void main(String[] args) {
        SpringApplication.run(ProjectManagementApplication.class, args);
    }

//    @Bean
//    CommandLineRunner runner(){
//        return args -> {
//        };
//    };
}
