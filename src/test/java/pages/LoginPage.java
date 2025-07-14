package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class LoginPage {
    private static final String LOGIN_FIELD = "[name=email]",
            PASSWORD_FIELD = "[name=password]",
            FORGOT_PASSWORD_LINK = "a[href='/password/reset']",
            REMEMBER_ME = "[name=remember]",
            ERROR_MESSAGE_EMPTY = "//div/following::small",
            ERROR_MESSAGE_WRONG = "//div[@role='alert']",
            THIS_FILED_IS_REQUIRED = "This field is required",
            THESE_CREDENTIALS_DO_NOT_MATCH_OUR_RECORDS = "These credentials do not match our records.",
            RESET_YOUR_PASSWORD = "Reset your password";

    @Step("Открытие страницы Login Page")
    public LoginPage openPage() {
        log.info("Opening login page");
        open("/login");
        return this;
    }

    @Step("Авторизация")
    public ProjectsPage login(String user, String password) {
        log.info("Login with username: {} and password: {}", user, password);
        $(LOGIN_FIELD).setValue(user);
        $(PASSWORD_FIELD).setValue(password).pressEnter();
        return new ProjectsPage();
    }

    @Step("Проверка сообщения об ошибке с пустыми данными")
    public void isErrorMessageEmptyDataVisible() {
        log.info("Checking a error message with empty data");
        $x(ERROR_MESSAGE_EMPTY).shouldHave(exactText(THIS_FILED_IS_REQUIRED)).shouldBe(visible, Duration.ofSeconds(20));
    }

    @Step("Проверка сообщения об ошибки с неправильными данными")
    public void isErrorMessageWrongDataVisible() {
        log.info("Checking a error message with wrong data");
        $x(ERROR_MESSAGE_WRONG).shouldHave(exactText((THESE_CREDENTIALS_DO_NOT_MATCH_OUR_RECORDS)))
                .shouldBe(visible, Duration.ofSeconds(20));
    }

    @Step("Проверка кнопки Forgot Passwor")
    public void isForgotPasswordButtonVisible() {
        log.info("Checking forgot password button is visible");
        $(FORGOT_PASSWORD_LINK).click();
        $(byText(RESET_YOUR_PASSWORD)).shouldBe(visible);
    }

    @Step("Проверки кнопки Remember Me")
    public void isRememberMeButtonClickable() {
        log.info("Checking remember me button is clickable");
        $(REMEMBER_ME).shouldBe(clickable);
    }
}

