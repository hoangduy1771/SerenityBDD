package exampletc;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;


@RunWith(SerenityRunner.class)
public class GmailLoginThroughStackOverflow extends PageObject {


    @Managed
    WebDriver driver;

    @Title("Execute Gmail Login Test")
    @Test
    public void gmailLogin() throws InterruptedException {
        openUrl("https://stackoverflow.com/users/login");
        find(By.xpath("//button[text()[normalize-space()='Log in with Google']]")).click();

        find(By.xpath("//input[@type='email']")).sendKeys("hoangduy1772@gmail.com");

//        Actions action = new Actions(driver);
//        action.click(find(By.xpath("//span[text()='Next']"))).perform();
        find(By.xpath("//*[contains(text(),'Next')]")).click();

//        Fluent wait
//        this will wait for 2 second by default built-in
//        waitForCondition().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()[normalize-space()='This browser or app may not be secure.']]")));

//        this is also fluent wait but with timeout increase to 5 from default is 2
        waitForCondition().withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(500))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()[normalize-space()='This browser or app may not be secure.']]")));



        Thread.sleep(2000);

    }


}


















