package tests;

import org.testng.annotations.Test;

public class RepositoryTest extends BaseTest {

    @Test(testName = "Добавление набора")
    public void checkAddSuite() {
        String name = "QaseTest";
        loginPage.openPage();
        loginPage.login("immortalis.mors0@gmail.com", "xPB-5KR-v8L-4WK");
        repositoryPage.openPage();
        repositoryPage.addSuite(name);
        repositoryPage.isAddSuite(name);
    }

    @Test(testName = "Удаление пароля")
    public void checkDeleteSuite() {
        loginPage.openPage();
        loginPage.login("immortalis.mors0@gmail.com", "xPB-5KR-v8L-4WK");
        repositoryPage.openPage();
        repositoryPage.deleteSuite();
        repositoryPage.isAddSuite("QaseTest");
    }

    @Test(testName = "Проверка кнопки Create Case")
    public void checkCreateCase() {
        loginPage.openPage();
        loginPage.login("immortalis.mors0@gmail.com", "xPB-5KR-v8L-4WK");
        repositoryPage.openPage();
        repositoryPage.createCase();
        testCaseModal.isPageOpened();
        testCaseModal.createTestCase("Qase1");
    }
}
