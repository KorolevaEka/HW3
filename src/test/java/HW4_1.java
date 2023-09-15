
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class HW4_1 {

    @Test
    void softAssertionsInSelenide () {
        open("https://github.com/selenide/selenide");

        $x("//a[@id='wiki-tab']").click();
        $x("//li[@class='Box-row wiki-more-pages-link']//button").click();
        $x("//div[@id='wiki-pages-box']").shouldHave(text("SoftAssertions"));
        $x("//span//a[@href=\"/selenide/selenide/wiki/SoftAssertions\"]").click();
        $x("//div[@class='markdown-body']").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})"));


    }

}
