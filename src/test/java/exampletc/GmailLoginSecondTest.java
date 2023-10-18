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
public class GmailLoginSecondTest {

    @Managed(driver = "firefox")
    WebDriver driver;

    @Steps
    HomePageSteps homePageSteps;

    @Title("Executing 3rd test")
    @Test
    @Screenshots(forEachAction = true)
    public void TC0003_SuccessfulLoginTest() {
        homePageSteps.userLoginToGmail();
        homePageSteps.verifyText();

    }
}


















