package tests.api;

import adapters.CaseAPI;
import models.CaseRq;
import org.testng.annotations.Test;


public class CaseAPITest {
    String code;
    String id;

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

    @Test(priority = 1)
    public void createTestCase() {
        id = CaseAPI.createCase(rq);
        code = CaseAPI.createCase(rq);
    }

    @Test(priority = 2)
    public void deleteTestCase() {
        CaseAPI.deleteCase(id,code);
    }
}
