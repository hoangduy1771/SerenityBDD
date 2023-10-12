package webelements;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;


@RunWith(SerenityRunner.class)
public class HandlingMultipleWindows extends PageObject {

    @Managed
    WebDriver driver;

    @Test
    public void handlingMultipleWindows() {

        openUrl("https://www.google.com");
//        open a new window and switch to it
        getDriver().switchTo().newWindow(WindowType.WINDOW);
        openUrl("https://9gag.com/");

//        bonus
//        run javascript/ run already existed javascript function on page
//        you can parse the whole javascript inside evaluateJavascript("()=> document.getElementById("id").innerHTML = x", find(By.xpath(""))
//        evaluateJavascript("myFunction()");
//        inject javascript highlight an element on page
        evaluateJavascript("arguments[0].style.border='3px solid red'", $("(//div[@class='list-stream' and contains(@id, 'stream')]//h2)[1]"));


        String verifyFirstPostTextHeader = find(By.xpath("(//div[@class='list-stream' and contains(@id, 'stream')]//h2)[1]")).getText();
        System.out.println("First post header found: " + verifyFirstPostTextHeader);

//        switch back to first browser and do some actions
        ArrayList<String> windows = new ArrayList<String> (getDriver().getWindowHandles());
        getDriver().switchTo().window(windows.get(0));
        find(By.name("q")).sendKeys("What time is it?" + Keys.ENTER);

        String textVerifyGoogleTime = find(By.xpath("//div[contains(@class,'card-section')]/div[@role='heading']")).getText();
        System.out.println("Navigated back to google, text found: " + textVerifyGoogleTime);
        driver.quit();

//        withAction().pause(Duration.ofSeconds(5)).perform();


    }


}
