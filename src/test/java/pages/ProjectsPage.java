package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class ProjectsPage {

    private static final String CREATE_NEW_PROJECT_BUTTON = "//span[text()='Create new project']",
            CREATE_NEW_PROJECT = "Create new project",
            PROJECT_NAME = "[id=project-name]",
            GROUP_ACCESS = "input[value=group]",
            SELECT_VALUE_ACCESS = "//*[@placeholder='Select value']",
            OWNER_GROUP_ACCESS = "//*[@placeholder='Type to search']",
            DONT_ADD_MEMBERS_ACCESS = "[value=none]",
            PUBLIC_ACCESS = "[value=public]",
            OPEN_ACTION_MENU = "[aria-label='Open action menu']",
            REMOVE_BUTTON = "[data-testid=remove]",
            DELETE_PROJECT = "//span[text()='Delete project']",
            ANY_PROJECT_YET = "Looks like you don’t have any projects yet.",
            CREATE_PROJECT_BUTTON = "[type=submit]";

    @Step("Проверка открыта ли страница Projects Page")
    public ProjectsPage isPageOpened() {
        log.info("Checking if the project page is open");
        $(byText(CREATE_NEW_PROJECT)).shouldBe(visible, Duration.ofSeconds(50));
        return this;
    }

    @Step("Создание нового проекта")
    public ProjectsPage fillProject(String name) {
        log.info("Filling a project with name: {}", name);
        $x(CREATE_NEW_PROJECT_BUTTON).click();
        $(PROJECT_NAME).setValue(name);
        return this;
    }

    @Step("Проверка заполения доступов")
    public ProjectsPage checkingAccess() {
        log.info("Checking access");
        $(GROUP_ACCESS).click();
        $x(SELECT_VALUE_ACCESS).click();
        $x(OWNER_GROUP_ACCESS).click();
        $(DONT_ADD_MEMBERS_ACCESS).click();
        $(PUBLIC_ACCESS).click();
        return this;
    }

    @Step("Удаление проекта")
    public ProjectsPage deleteProject() {
        log.info("Deleting a project");
        $(OPEN_ACTION_MENU).click();
        $(REMOVE_BUTTON).click();
        $x(DELETE_PROJECT).click();
        return this;
    }

    @Step("Проверка удаления проекта")
    public void isProjectDelete() {
        log.info("Checking deletion of a project");
        $(byText(ANY_PROJECT_YET)).shouldBe(visible);
    }

    @Step("Нажатие на кнопку создания проекта")
    public RepositoryPage clickCreateProject() {
        $(CREATE_PROJECT_BUTTON).click();
        return new RepositoryPage();
    }
}
