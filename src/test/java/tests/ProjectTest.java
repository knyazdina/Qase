package tests;

import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    @Test(testName = "Создание проекта")
    public void createProject() {
        loginPage.openPage()
                .login("immortalis.mors0@gmail.com", "xPB-5KR-v8L-4WK")
                .isPageOpened()
                .fillProject("Qase")
                .checkingAccess()
                .clickCreateProject()
                .isPageOpened();
    }

    @Test(testName = "Удаление проекта")
    public void deleteProject() {
        loginPage.openPage()
                .login("immortalis.mors0@gmail.com", "xPB-5KR-v8L-4WK")
                .isPageOpened()
                .deleteProject()
                .isProjectDelete();
    }
}
