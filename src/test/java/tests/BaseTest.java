package tests;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.ProjectsPage;
import pages.RepositoryPage;
import pages.TestCaseModal;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class BaseTest {
    String user = System.getProperty("user", PropertyReader.getProperty("user"));
    String password = System.getProperty("password", PropertyReader.getProperty("password"));

    LoginPage loginPage;
    ProjectsPage projectsPage;
    RepositoryPage repositoryPage;
    TestCaseModal testCaseModal;

    @BeforeMethod
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://app.qase.io";
        Configuration.timeout = 10000;
        Configuration.clickViaJs = true;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        Configuration.browserCapabilities = options;

        loginPage = new LoginPage();
        projectsPage = new ProjectsPage();
        repositoryPage = new RepositoryPage();
        testCaseModal = new TestCaseModal();
    }

    /* SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
             .screenshots(false)
             .savePageSource(true)
     );
 }
*/
    @AfterMethod(alwaysRun = true)

    public void tearDown() {
        closeWebDriver();
    }
}
