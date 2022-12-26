
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class FirstTest extends TestBase {

        @Test
        protected void fillFormTest() {
            step("Open registration form", () -> {
                        open("/automation-practice-form");
                        executeJavaScript("$('footer').remove()");
                        executeJavaScript("$('#fixedban').remove()");
            });
            step("Fill form", () -> {
            $("#firstName").setValue("Dmitrii");
            $("#lastName").setValue("Aleksandrov");
            $("#userEmail").setValue("123@mail.com");
            $(byText("Male")).click();
            $("#userNumber").setValue("1234567899");
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").click();
            $(".react-datepicker__month-select").selectOption("January");
            $(".react-datepicker__year-select").click();
            $(".react-datepicker__year-select").selectOption("2000");
            $(".react-datepicker__year-select").click();
            $(".react-datepicker__day--005").click();
            $("#subjectsInput").setValue("Math").pressEnter();
            $(byText("Sports")).click();
            $("#uploadPicture").uploadFile(new File("src/test/resources/test.jpg"));
            $("#currentAddress").setValue("Lenina street 1");
            $("#state").click();
            $(byText("NCR")).click();
            $("#city").click();
            $(byText("Gurgaon")).click();
            $("#submit").click();
            });
            step("Check form results", () -> {
            $(".modal-content").shouldBe(visible);
            $(".modal-body").shouldHave(text("Dmitrii"),
                    text("Dmitrii"),
                    text("Aleksandrov"),
                    text("123@mail.com"),
                    text("Male"),
                    text("1234567899"),
                    text("5 January,2000"),
                    text("Math"),
                    text("Sports"),
                    text("test.jpg"),
                    text("Lenina street 1"),
                    text("NCR"),
                    text("Gurgaon"));
                });
        }
    }

