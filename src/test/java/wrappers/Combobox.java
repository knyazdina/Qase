package wrappers;

import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2

public class Combobox {

    String label;

    public Combobox(String label) {
        this.label = label;
    }

    public void click(String option) {
        log.info("Select {} from {}", label, option);
        $x(String.format("//label[text()='%s']/ancestor::div//input[@role='combobox']", label))
                .shouldBe(visible)
                .click();
        $x(String.format("//label[text()='%s']//input[@role='checkbox']", label, option))
                .shouldBe(visible)
                .click();
    }
}
