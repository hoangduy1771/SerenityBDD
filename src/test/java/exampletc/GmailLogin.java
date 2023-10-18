package exampletc;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Screenshots;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.HomePageSteps;

@RunWith(SerenityRunner.class)
public class GmailLogin {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    HomePageSteps homePageSteps;


    @Title("Executing 1st test")
    @Test
    @Screenshots(onlyOnFailures = true)
    public void TC0001_SuccessfulLoginTest() {
        homePageSteps.userLoginToGmail();
        homePageSteps.verifyText();

    }
    @Title("Executing 2nd test")
    @Test
    @Screenshots(afterEachStep = true)
    public void TC0002_SuccessfulLoginTest() {
        homePageSteps.userLoginToGmail();
        homePageSteps.verifyText();

    }

}


















