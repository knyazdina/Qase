package pages;

import lombok.extern.log4j.Log4j2;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class RepositoryPage {

    private static final String OPEN_PROJECT = "a[href='/project/QASE']";
    private static final String ADD_SUITE = "[id='create-suite-button']";
    private static final String SUITE_NAME = "[id=title]";
    private static final String CREATE_BUTTON = "[type=submit]";

    public void openPage() {
        log.info("Opening repository page");
        $(OPEN_PROJECT).click();
    }

    public void isPageOpened() {
        log.info("Checking if the repository page is open");
        $(byText("QASE")).shouldBe(visible, Duration.ofSeconds(75));
    }

    public void addSuite(String name) {
        log.info("Adding a suite with name: {}", name);
        $(ADD_SUITE).click();
        $(SUITE_NAME).setValue(name);
        $(CREATE_BUTTON).click();
    }

    public void isAddSuite() {
        log.info("Checking if suite is added");
        $(byText("QaseTest")).shouldBe(visible, Duration.ofSeconds(75));
    }

    public void deleteSuite() {
        log.info("Checking deletion of a suite");
        $("[aria-label='Delete suite']").click();
        $("[type='submit']").click();
    }

    public void createCase() {
        log.info("Creating a case");
        $("[id='create-case-menu-trigger']").shouldBe(visible).click();
        $("[role=menuitem]").click();
    }
}
