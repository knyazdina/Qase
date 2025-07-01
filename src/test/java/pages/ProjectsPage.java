package pages;

import lombok.extern.log4j.Log4j2;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class ProjectsPage {

    private static final String CREATE_NEW_PROJECT_BUTTON = "//span[text()='Create new project']";
    private static final String PROJECT_NAME = "[id=project-name]";

    public void isPageOpened() {
        log.info("Checking if the project page is open");
        $(byText("Create new project")).shouldBe(visible, Duration.ofSeconds(75));
    }

    public void fillProject(String name) {
        log.info("Filling a project with name: {}", name);
        $x(CREATE_NEW_PROJECT_BUTTON).click();
        $(PROJECT_NAME).setValue(name);
    }

    public void access() {
        log.info("Checking access");
        $("input[value=group]").click();
        $x("//*[@placeholder='Select value']").click();
        $x("//*[@placeholder='Type to search']").click();
        $("[value=none]").click();
        $("[value=public]").click();
    }

    public void deleteProject() {
        log.info("Deleting a project");
        $("[aria-label='Open action menu']").click();
        $("[data-testid=remove]").click();
        $x("//span[text()='Delete project']").click();
    }

    public void isProjectDelete() {
        log.info("Checking deletion of a project");
        $($(byText("Looks like you don’t have any projects yet."))
                .shouldBe(visible, Duration.ofSeconds(75)));
    }
}
