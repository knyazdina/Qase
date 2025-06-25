package wrappers;


import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2

public class CheckBox {

    String label;

    public CheckBox(String label) {
        this.label = label;
    }

    public void click(String label) {
        log.info("Сlick on {}", label);
        $x(String.format("//label[text()='%s']//input[@type='checkbox']", label))
                .shouldBe(visible)
                .click();
    }
}

