import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HW3 {
    @BeforeAll
    static void beforeAll(){
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = 10000;
        Configuration.browserSize = "768x1024";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy="eager";
    }
    @Test
    void testForm() {
        open("/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

//
//        $x("//input[@id='firstName']").setValue("Kate");
//        $x("//input[@id='lastName']").setValue("Hanami");
//        $x("//input[@id='userEmail']").setValue("pass@gmail.com");
//        $x("//*[contains(text(),'Female')]").click();
//        $x("//input[@id='userNumber']").setValue("+792510029");
//        $x("//input[@id='dateOfBirthInput']").click();
//        $x("//select[@class= 'react-datepicker__month-select']").selectOption("June");
//        $x("//select[@class= 'react-datepicker__year-select']").selectOption("2000");
//        $x("//div[@class= 'react-datepicker__day react-datepicker__day--019']").click();
//        $("#subjectsInput").setValue("Math").pressEnter();
//        $("label[for='hobbies-checkbox-2']").click();
//        $x("//input[@type='file']").uploadFromClasspath("msk.jpg");
//        $("#currentAddress").setValue("Frog, 3");
//        $("#react-select-3-input").setValue("NCR").pressEnter();
//        $("#react-select-4-input").setValue("Delhi").pressEnter();
//
//
//        $("#submit").click();
//
////        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
//
//        $x("//div[@class='modal-body']").shouldHave(
//                text("Kate" +" "+ "Hanami"),
//                text("pass@gmail.com"),
//                text("+792510029"),
//                text("Frog, 3"),
//                text("NCR" +" "+"Delhi")
//        );
//
//    }

        String firstName = "Kate",
                lastName = "Hanami",
                email = "test@test.com",
                gender = "Female",
                number = "8737891087",
                year = "2000",
                month = "August",
                day = "02",
                subject = "Maths",
                hobby = "Sports",
                picture = "msk.jpg",
                address = "Duck 3",
                state = "NCR",
                city = "Delhi";
        String tablesValueXpath = "//td[text()='%s']/../td[text()='%s']";


        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(number);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$(byText(year)).click();
        $(".react-datepicker__month-select").$(byText(month)).click();
        $(".react-datepicker__day--0" + day).click();
        $("#subjectsContainer input").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobby)).click();
        $("#uploadPicture").uploadFromClasspath(picture);
        $("#currentAddress").setValue(address);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        $("#submit").click();



        $x(String.format(tablesValueXpath, "Student Name", firstName + " " + lastName)).shouldBe(visible);
        $x(String.format(tablesValueXpath, "Student Email", email)).shouldBe(visible);
        $x(String.format(tablesValueXpath, "Gender", gender)).shouldBe(visible);
        $x(String.format(tablesValueXpath, "Mobile", number)).shouldBe(visible);
        $x(String.format(tablesValueXpath, "Date of Birth", day + " " + month + "," + year)).shouldBe(visible);
        $x(String.format(tablesValueXpath, "Subjects", subject)).shouldBe(visible);
        $x(String.format(tablesValueXpath, "Hobbies", hobby)).shouldBe(visible);
        $x(String.format(tablesValueXpath, "Picture", picture)).shouldBe(visible);
        $x(String.format(tablesValueXpath, "Address", address)).shouldBe(visible);
        $x(String.format(tablesValueXpath, "State and City", state + " " + city)).shouldBe(visible);

    }
}
