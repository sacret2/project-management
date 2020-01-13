package com.jrp.pma.dao;

import com.jrp.pma.ProjectManagementApplication;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.entities.Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(classes = ProjectManagementApplication.class)
@RunWith(SpringRunner.class)
@DataJpaTest
@SqlGroup({@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:schema.sql", "classpath:data.sql"}),
@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = {"classpath:drop.sql"})})
public class ProjectRepositoryIntegrationTest {
    @Autowired
    ProjectRepository proRepo;

    @Test
    public void ifNewProjectSaved_thenSuccess(){
        Project newProject = new Project("New Test Project", "Complete","Test description");
        proRepo.save(newProject);

        assertEquals(9, proRepo.findAll().size());
    }

}
