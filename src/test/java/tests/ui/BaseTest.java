package tests.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.ProjectsPage;
import pages.RepositoryPage;
import pages.TestCasePage;
import utils.PropertyReader;
import utils.TestListener;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@Listeners(TestListener.class)
public class BaseTest {
    String user = System.getProperty("user", PropertyReader.getProperty("user"));
    String password = System.getProperty("password", PropertyReader.getProperty("password"));

    LoginPage loginPage;
    ProjectsPage projectsPage;
    RepositoryPage repositoryPage;
    TestCasePage testCasePage;

    @Parameters({"browser"})
    @BeforeMethod
    public void setup(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            Configuration.browser = "chrome";
            Configuration.baseUrl = "https://app.qase.io";
            Configuration.timeout = 10000;
            Configuration.clickViaJs = true;
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            //options.addArguments("--headless");
            Configuration.browserCapabilities = options;
        } else if (browser.equalsIgnoreCase("firefox")) {
            Configuration.browser = "firefox";
            FirefoxOptions options = new FirefoxOptions();
            Configuration.browserCapabilities = options;
            options.addArguments("--headless");
            options.addArguments("--start-maximized");
            Configuration.timeout = 10000;
        }

        loginPage = new LoginPage();
        projectsPage = new ProjectsPage();
        repositoryPage = new RepositoryPage();
        testCasePage = new TestCasePage();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        closeWebDriver();
    }
}
