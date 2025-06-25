package wrappers;

import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2

public class Text {

    String label;

    public Text(String label) {
        this.label = label;
    }

    public void write(String text) {
        log.info("Writhing {} in to {}", text, label);
        $x(String.format("//label[text()='Title']/ancestor::div//input[@name='title']", label))
                .shouldBe(visible)
                .setValue(text);
    }
}



