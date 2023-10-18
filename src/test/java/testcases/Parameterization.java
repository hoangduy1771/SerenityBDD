package testcases;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Screenshots;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.HomePage9gagSteps;
import steps.HomePageSteps;

import java.util.Arrays;
import java.util.Collection;


@RunWith(SerenityParameterizedRunner.class)
public class Parameterization {

    private final String username;
    private final String password;



    public Parameterization(String username, String password) {
        this.username = username;
        this.password = password;

    }


    @TestData
    public static Collection<Object[]> testData() {
        Object[][] data = new Object[2][2];

        data[0][0] = "username1";
        data[0][1] = "password1";

        data[1][0] = "username2";
        data[1][1] = "password2";

        return Arrays.asList(data);
    }

//    make another step page to login something else than gmail

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    HomePage9gagSteps homepage9gagSteps;

    @Title("Executing test")
    @Test
    public void TC0001_loginTo9gag() {
        homepage9gagSteps.userNavigateTo("https://9gag.com/");
        homepage9gagSteps.userClickOnButtonOrLink("Sign Up/Log In");
        homepage9gagSteps.userClickOnButtonOrLink("Already a member? Log in");
        homepage9gagSteps.userEnterUsername(username);
        homepage9gagSteps.userEnterPassword(password);
        homepage9gagSteps.userVerifyButtonState(true, "Log in");

    }

}


