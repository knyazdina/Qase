package tests.api;

import adapters.ProjectAPI;
import models.ProjectRq;
import org.testng.annotations.Test;


public class ProjectAPITest {

    String code;

    ProjectRq rq = ProjectRq.builder()
            .title("QaseTest")
            .code("QT")
            .description("test")
            .access("all")
            .build();

    @Test(priority = 1)
    public void createTest() {
        code = ProjectAPI.createProject(rq);
    }

    @Test(priority = 2)
    public void getTest() {
        ProjectAPI.getProject(code);
    }

    @Test(priority = 3)
    public void deleteTest() {
        ProjectAPI.deleteProject(code);
    }
}
