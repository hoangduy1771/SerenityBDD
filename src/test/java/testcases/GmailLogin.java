package testcases;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;


@RunWith(SerenityRunner.class)
public class GmailLogin extends PageObject {


    @Managed
    WebDriver driver;

    @Title("Execute Gmail Login Test")
    @Test
    public void gmailLogin() throws InterruptedException {
        openUrl("https://stackoverflow.com/users/login");
        find(By.xpath("//button[text()[normalize-space()='Log in with Google']]")).click();

        find(By.xpath("//input[@type='email']")).sendKeys("hoangduy1772@gmail.com");
        find(By.xpath("//span[text()='Next']")).click();

//        Fluent wait
//        this will wait for 2 second by default
//        waitForCondition().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()[normalize-space()='This browser or app may not be secure.']]")));

//        this is also fluent wait but with timeout increase to 3 from default is 2
        waitForCondition().withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofMillis(500))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()[normalize-space()='This browser or app may not be secure.']]")));



        Thread.sleep(2000);

    }


}


















