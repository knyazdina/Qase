package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class LoginTest extends BaseTest {

    @Test
    public void checkLoginWithPositiveCred() {
        log.info("Login with positive cred");
        loginPage.openPage();
        loginPage.login("immortalis.mors0@gmail.com", "xPB-5KR-v8L-4WK");
        projectsPage.isPageOpened();
    }

    @Test
    public void checkLoginWithEmptyLogin() {
        log.info("Login with empty login");
        loginPage.openPage();
        loginPage.login("", "xPB-5KR-v8L-4WK");
        loginPage.errorMessageEmptyData();
    }

    @Test
    public void checkLoginWithEmptyPassword() {
        log.info("Login with empty password");
        loginPage.openPage();
        loginPage.login("immortalis.mors0@gmail.com", "");
        loginPage.errorMessageEmptyData();
    }

    @Test
    public void checkLoginWithWrongLogin() {
        log.info("Login with wrong login");
        loginPage.openPage();
        loginPage.login("immortalis.mor0@gmail.com", "xPB-5KR-v8L-4WK");
        loginPage.errorMessageWrongData();
    }

    @Test
    public void checkLoginWithWrongPassword() {
        log.info("Login with wrong password");
        loginPage.openPage();
        loginPage.login("immortalis.mors0@gmail.com", "xPB-5R-v8L-4WK");
        loginPage.errorMessageWrongData();
    }

    @Test
    public void checkForgotPasswordButton() {
        log.info("Checking a forgot password button");
        loginPage.openPage();
        loginPage.forgotPasswordButton();
    }

    @Test
    public void checkRememberMeButton() {
        log.info("Checking a remember me button");
        loginPage.openPage();
        loginPage.rememberMeButton();
    }
}
