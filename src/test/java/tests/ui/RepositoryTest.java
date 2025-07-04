package tests.ui;

import org.testng.annotations.Test;

public class RepositoryTest extends BaseTest {

    String name = "QaseTest";

    @Test(testName = "Добавление набора", priority = 1)
    public void checkAddSuite() {
        loginPage.openPage();
        loginPage.login(user, password);
        repositoryPage.openPage();
        repositoryPage.addSuite(name);
        repositoryPage.isAddSuite(name);
    }

    @Test(testName = "Удаление набора", priority = 2)
    public void checkDeleteSuite() {
        loginPage.openPage();
        loginPage.login(user, password);
        repositoryPage.openPage();
        repositoryPage.deleteSuite();
        repositoryPage.isAddSuite(name);
    }

    @Test(testName = "Проверка кнопки Create Case", priority = 3)
    public void checkCreateCase() {
        loginPage.openPage();
        loginPage.login(user, password);
        repositoryPage.openPage();
        repositoryPage.createCase();
        testCaseModal.isPageOpened();
        testCaseModal.createTestCase("Qase1");
    }
}
