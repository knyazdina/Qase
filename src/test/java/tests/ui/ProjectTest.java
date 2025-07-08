package tests.ui;

import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    @Test(testName = "Создание проекта", priority = 1)
    public void createProject() {
        loginPage.openPage()
                .login(user, password)
                .fillProject("Qase")
                .checkingAccess()
                .clickCreateProject()
                .isPageOpened();
    }

    @Test(testName = "Удаление проекта", priority = 2)
    public void deleteProject() {
        loginPage.openPage()
                .login(user, password)
                .deleteProject()
                .isProjectDelete();
    }
}
