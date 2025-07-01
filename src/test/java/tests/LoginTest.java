package tests;


import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test(testName = "Авторизация с валидными данными")
    public void checkLoginWithPositiveCred() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.isPageOpened();
    }

    @Test(testName = "Авторизация с пустым логином")
    public void checkLoginWithEmptyLogin() {
        loginPage.openPage();
        loginPage.login("", password);
        loginPage.isErrorMessageEmptyDataVisible();
    }

    @Test(testName = "Авторизация с пустым паролем")
    public void checkLoginWithEmptyPassword() {
        loginPage.openPage();
        loginPage.login(user, "");
        loginPage.isErrorMessageEmptyDataVisible();
    }

    @Test(testName = "Авторизация с неправильным логином")
    public void checkLoginWithWrongLogin() {
        loginPage.openPage();
        loginPage.login("immortalis.mor0@gmail.com", password);
        loginPage.isErrorMessageWrongDataVisible();
    }

    @Test(testName = "Авторизация с неправильным паролем")
    public void checkLoginWithWrongPassword() {
        loginPage.openPage();
        loginPage.login(user, "xPB-5R-v8L-4WK");
        loginPage.isErrorMessageWrongDataVisible();
    }

    @Test(testName = "Проверка кнопки Forgot Password")
    public void checkForgotPasswordButton() {
        loginPage.openPage();
        loginPage.isForgotPasswordButtonVisible();
    }

    @Test(testName = "Проверка кнопки Remember Me")
    public void checkRememberMeButton() {
        loginPage.openPage();
        loginPage.isRememberMeButtonClickable();
    }
}
