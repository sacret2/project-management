package com.jrp.pma.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.dto.ProjectStageCount;
import com.jrp.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HomeController {
    @Value("${version}")
    private String ver;

    @Autowired
    ProjectRepository projRepo;

    @Autowired
    EmployeeRepository emplRepo;

    @GetMapping("")
    public String displayHome(Model model, Principal user) throws JsonProcessingException {
        model.addAttribute("loggedin", user != null);

        Map<String, Object> map = new HashMap<>();

        model.addAttribute("version", ver);

        List<Project> projects = projRepo.findAll();
        model.addAttribute("projectList", projects);
        List<EmployeeProject> employeesProjectCnt = emplRepo.employeeProjects();
        model.addAttribute("employeeListProjectCnt", employeesProjectCnt);

        List<ProjectStageCount> projectStageCounts = projRepo.getProjectCountsByStage();

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectStageCounts);

        // [["NOTSTARTED", 1], ["INPROGRESS", 2], ["COMPLETED", 1]]
        model.addAttribute("projectStatusCnt", jsonString);

        return "main/home";
    }
}
