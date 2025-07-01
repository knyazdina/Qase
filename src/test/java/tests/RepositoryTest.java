package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class RepositoryTest extends BaseTest {
    @Test
    public void checkAddSuite() {
        log.info("Checking if adding a suite");
        loginPage.openPage();
        loginPage.login("immortalis.mors0@gmail.com", "xPB-5KR-v8L-4WK");
        repositoryPage.openPage();
        repositoryPage.addSuite("QaseTest");
        repositoryPage.isAddSuite();
    }

    @Test
    public void checkDeleteSuite() {
        log.info("Checking if deleting a suite");
        loginPage.openPage();
        loginPage.login("immortalis.mors0@gmail.com", "xPB-5KR-v8L-4WK");
        repositoryPage.openPage();
        repositoryPage.deleteSuite();
        repositoryPage.isAddSuite();
    }

    @Test
    public void checkCreateCase() {
        log.info("Checking if creating a case");
        loginPage.openPage();
        loginPage.login("immortalis.mors0@gmail.com", "xPB-5KR-v8L-4WK");
        repositoryPage.openPage();
        repositoryPage.createCase();
        testCaseModal.isPageOpened();
        testCaseModal.createTestCase("Qase1");
    }
}
