package tests.api;

import adapters.CaseAPI;
import adapters.ProjectAPI;
import models.CaseRq;
import models.ProjectRq;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class CaseAPITest {
    String code;
    int id;

    CaseRq rq = CaseRq.builder()
            .title("QaseTest")
            .severity(3)
            .priority(1)
            .behavior(1)
            .type(1)
            .layer(2)
            .automation(1)
            .action("Create test case")
            .expected_result("Test case is created")
            .preconditions("Open browser")
            .postconditions("Close browser")
            .description("Test creating test case")
            .build();

    @BeforeClass
    public void createProject() {
        ProjectRq rq = ProjectRq.builder()
                .title("QaseTest")
                .code("QT")
                .description("test")
                .access("all")
                .build();

        code = ProjectAPI.createProject(rq);
    }

    @Test(priority = 1)
    public void createTestCase() {
        id = CaseAPI.createCase(code, rq);
    }

    @Test(priority = 2)
    public void deleteTestCase() {
        CaseAPI.deleteCase(id, code);
    }

    @AfterClass
    public void deleteProject() {
        ProjectAPI.deleteProject(code);
    }
}
