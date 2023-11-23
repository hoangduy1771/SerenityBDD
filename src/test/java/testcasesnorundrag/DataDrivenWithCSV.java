package testcasesnorundrag;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Narrative;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.TestData;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.HomePage9gagSteps;
import utils.ExcelReader;

import java.util.Arrays;
import java.util.Collection;

@Narrative(text={"In order to run DataDriven CSV tests",
        "As a Serenity Runner",
        "We need to Integrate Excel Reading"})
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(".\\src\\test\\resources\\data\\csv\\data.csv")
@Concurrent(threads = "4")
public class DataDrivenWithCSV {

    private String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
