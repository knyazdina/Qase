package pages;

import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class LoginPage {
    private static final String LOGIN_FIELD = "[name=email]";
    private static final String PASSWORD_FIELD = "[name=password]";
    private static final String FORGOT_PASSWORD_LINK = "a[href='/password/reset']";
    private static final String REMEMBER_ME = "[name=remember]";
    private static final String ERROR_MESSAGE_EMPTY = "//div/following::small";
    private static final String ERROR_MESSAGE_WRONG = "//div[@role='alert']";

    public void openPage() {
        log.info("Opening login page");
        open("/login");
    }

    public void login(String user, String password) {
        log.info("Login with username: {} and password: {}", user, password);
        $(LOGIN_FIELD).setValue(user);
        $(PASSWORD_FIELD).setValue(password).pressEnter();
    }

    public void errorMessageEmptyData() {
        log.info("Checking a error message with empty data");
        $x(ERROR_MESSAGE_EMPTY).shouldHave(exactText("This field is required"));
    }

    public void errorMessageWrongData() {
        log.info("Checking a error message with wrong data");
        $x(ERROR_MESSAGE_WRONG).shouldHave(exactText("These credentials do not match our records."));
    }

    public void forgotPasswordButton() {
        log.info("Checking forgot password button is visible");
        $(FORGOT_PASSWORD_LINK).click();
        $(byText("Reset your password")).shouldBe(visible);
    }

    public void rememberMeButton() {
        log.info("Checking remember me button is clickable");
        $(REMEMBER_ME).shouldBe(clickable);
    }
}

