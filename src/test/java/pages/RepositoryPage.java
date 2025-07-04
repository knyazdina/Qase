package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class RepositoryPage {

    private static final String OPEN_PROJECT = "a[href='/project/QASE']",
            PAGE_NAME = "QASE",
            ADD_SUITE = "[id='create-suite-button']",
            SUITE_NAME = "[id=title]",
            CREATE_BUTTON = "[type=submit]",
            DELETE_SUITE = "[aria-label='Delete suite']",
            DELETE_BUTTON = "[type='submit']",
            CREATE_CASE = "[id='create-case-menu-trigger']",
            CREATE_MANUALLY = "[role=menuitem]";


    @Step("Открытие страницы Repository Page")
    public void openPage() {
        log.info("Opening repository page");
        $(OPEN_PROJECT).click();
    }

    @Step("Проверка открыта ли страница")
    public void isPageOpened() {
        log.info("Checking if the repository page is open");
        $(byText(PAGE_NAME)).shouldBe(visible);
    }

    @Step("Создание набора")
    public void addSuite(String name) {
        log.info("Adding a suite with name: {}", name);
        $(ADD_SUITE).click();
        $(SUITE_NAME).setValue(name);
        $(CREATE_BUTTON).click();
    }

    @Step("Проверка создан ли набор")
    public void isAddSuite(String name) {
        log.info("Checking if suite with name: {} is added", name);
        $(byText(name)).shouldBe(visible);
    }

    @Step("Удаление набора")
    public void deleteSuite() {
        log.info("Checking deletion of a suite");
        $(DELETE_SUITE).click();
        $(DELETE_BUTTON).click();
    }

    @Step("Создание кейса")
    public void createCase() {
        log.info("Creating a case");
        $(CREATE_CASE).shouldBe(visible).click();
        $(CREATE_MANUALLY).click();
    }
}
