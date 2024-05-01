import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
public class PracticeFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void studentRegistrationFormTest(){
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");

        //Name
        $("#firstName").setValue("Test");
        $("#lastName").setValue("Testov");

        //Email
        $("#userEmail").setValue("test@test.com");

        //Gender
        $("#genterWrapper").$(byText("Other")).click();

        //Mobile
        $("#userNumber").setValue("8909876543");

        //Date of Birth
        $("#dateOfBirthInput").click();
        $("#submit").scrollIntoView(true);
        $(".react-datepicker__year-select").selectOption("2018");
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__day--028").click();

        //Subjects
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();

        //Hobbies
        $("#hobbiesWrapper").$(byText("Sports")).click();

        //Picture
        $("#uploadPicture").uploadFromClasspath("Picture.jpg");

        //Current Address
        $("#currentAddress").setValue("Street Test 1");

        //State and City
        $("#stateCity-wrapper #state").click();
        $("#stateCity-wrapper #state").$(byText("Uttar Pradesh")).click();
        $("#stateCity-wrapper #city").click();
        $("#stateCity-wrapper #city").$(byText("Lucknow")).click();

        //Submit
        $("#submit").click();

        //Check the completed form
        $x("//td[contains(text(),'Student Name')]/../td[2]").shouldHave(text("Test Testov"));
        $x("//td[contains(text(),'Student Email')]/../td[2]").shouldHave(text("test@test.com"));
        $x("//td[contains(text(),'Gender')]/../td[2]").shouldHave(text("Other"));
        $x("//td[contains(text(),'Mobile')]/../td[2]").shouldHave(text("8909876543"));
        $x("//td[contains(text(),'Date of Birth')]/../td[2]").shouldHave(text("28 July,2018"));
        $x("//td[contains(text(),'Subjects')]/../td[2]").shouldHave(text("Computer Science"));
        $x("//td[contains(text(),'Hobbies')]/../td[2]").shouldHave(text("Sport"));
        $x("//td[contains(text(),'Picture')]/../td[2]").shouldHave(text("Picture.jpg"));
        $x("//td[contains(text(),'Address')]/../td[2]").shouldHave(text("Street Test 1"));
        $x("//td[contains(text(),'State and City')]/../td[2]").shouldHave(text("Uttar Pradesh Lucknow"));
    }
}
