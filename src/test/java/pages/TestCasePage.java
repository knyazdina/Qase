package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class TestCasePage {

    private static final String CREATE_TEST_CASE = "Create test case",
            TITLE = "//input[@name='title']";

    @Step("Проверка открыта ли страница Test Case Modal")
    public void isPageOpened() {
        log.info("Checking if the test case page is open");
        $(byText(CREATE_TEST_CASE)).shouldBe(visible, Duration.ofSeconds(20));
    }

    @Step("Создание тест кейса")
    public void createTestCase(String title) {
        log.info("Creating a test case");
        $x(TITLE).setValue(title);
    }
}
