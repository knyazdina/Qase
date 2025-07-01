package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class ProjectTest extends BaseTest {

    @Test
    public void createProject() {
        log.info("Checking if adding a project");
        loginPage.openPage();
        loginPage.login("immortalis.mors0@gmail.com", "xPB-5KR-v8L-4WK");
        projectsPage.isPageOpened();
        projectsPage.fillProject("Qase");
        projectsPage.access();
        $("[type=submit]").click();
        repositoryPage.isPageOpened();
    }

    @Test
    public void deleteProject() {
        log.info("Checking if deleting a project");
        loginPage.openPage();
        loginPage.login("immortalis.mors0@gmail.com", "xPB-5KR-v8L-4WK");
        projectsPage.isPageOpened();
        projectsPage.deleteProject();
        projectsPage.isProjectDelete();
    }
}
