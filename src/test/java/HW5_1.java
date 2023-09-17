import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class HW5_1 {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    public void entrprisePage() {
        open("/");
        $(".header-menu-wrapper").$(byTagAndText("button", "Solutions")).hover();
        $(".header-menu-wrapper").$(byTagAndText("a", "Enterprise")).click();
        $(withText("Build like the best")).shouldBe(visible);

    }
}
