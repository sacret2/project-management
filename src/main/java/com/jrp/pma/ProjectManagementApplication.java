package com.jrp.pma;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
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
//            Employee emp1 = new Employee("AA", "Aa", "a@a");
//            Employee emp2 = new Employee("BA", "Ba", "b@a");
//            Employee emp3 = new Employee("CA", "Ca", "c@a");
//            Employee emp4 = new Employee("DA", "Da", "d@a");
//            Employee emp5 = new Employee("EA", "Ea", "e@a");
//            Employee emp6 = new Employee("FA", "Fa", "f@a");
//            Employee emp7 = new Employee("GA", "Ga", "g@a");
//            Employee emp8 = new Employee("HA", "Ha", "h@a");
//            Employee emp9 = new Employee("IA", "Ia", "i@a");
//
//            Project proj1 = new Project("p1", "INPROGRESS","p_descr1");
//            Project proj2 = new Project("p2", "INPROGRESS","p_descr2");
//            Project proj3 = new Project("p3", "INPROGRESS","p_descr3");
//            Project proj4 = new Project("p4", "INPROGRESS","p_descr4");
//            Project proj5 = new Project("p5", "INPROGRESS","p_descr5");
//            Project proj6 = new Project("p6", "INPROGRESS","p_descr6");
//            Project proj7 = new Project("p7", "INPROGRESS","p_descr7");
//            Project proj8 = new Project("p8", "INPROGRESS","p_descr8");
//            Project proj9 = new Project("p9", "INPROGRESS","p_descr9");
//
//            proj1.addEmployee(emp1);
//            proj1.addEmployee(emp2);
//            proj2.addEmployee(emp3);
//            proj3.addEmployee(emp1);
//            proj4.addEmployee(emp1);
//            proj4.addEmployee(emp3);
//
//            emp1.setProjects(Arrays.asList(proj1, proj3, proj4));
//            emp2.setProjects(Arrays.asList(proj1));
//            emp3.setProjects(Arrays.asList(proj2, proj4));
//
//            empRepo.save(emp1);
//            empRepo.save(emp2);
//            empRepo.save(emp3);
//            empRepo.save(emp4);
//            empRepo.save(emp5);
//            empRepo.save(emp6);
//            empRepo.save(emp7);
//            empRepo.save(emp8);
//            empRepo.save(emp9);
//
////            projRepo.save(proj1);
////            projRepo.save(proj2);
////            projRepo.save(proj3);
////            projRepo.save(proj4);
//
//            //empRepo.saveAll((Iterable<Employee>)Arrays.asList(emp1,emp2,emp3,emp4,emp5,emp6,emp7,emp8,emp9));
//            //projRepo.saveAll(Arrays.asList(proj1,proj2,proj3,proj4,proj5,proj6,proj7,proj8,proj9));
//        };
//    };
}
