package pages;

import lombok.extern.log4j.Log4j2;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class TestCaseModal {
    public void isPageOpened() {
        log.info("Checking if the test case page is open");
        $(byText("Create test case")).shouldBe(visible, Duration.ofSeconds(75));
    }

    public void createTestCase(String title) {
        log.info("Creating a test case");
        $x("//input[@name='title']").setValue(title);
    }
}
