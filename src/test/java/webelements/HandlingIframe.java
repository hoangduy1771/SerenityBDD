package webelements;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;


@RunWith(SerenityRunner.class)
public class HandlingIframe extends PageObject {

    @Managed
    WebDriver driver;

    @Test
    public void handlingIframe() {
        openUrl("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");

//        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

//        switch to iframe using name or id
//        getDriver().switchTo().frame("iframeResult");

//        get iframe with xpath
        WebElement iframeResult = find(By.xpath("//iframe[@id='iframeResult']"));
        getDriver().switchTo().frame(iframeResult);

//        submit button
        WebElement submitButton = find(By.xpath("//button[text()='Try it']"));
        submitButton.click();

//        verify "Submit the form" text appear
        String verifyText = find(By.xpath("//p[@id='demo']")).getText();
        System.out.println("Verify: " + verifyText);

//        switch back to html content to get number of iframe present
        getDriver().switchTo().defaultContent();

//        get frames id
        ListOfWebElementFacades iFrameList = findAll(By.tagName("iframe"));
        for (WebElementFacade frame : iFrameList) {
            System.out.println("Frame id: " + frame);
        }

        int iframeNumber = iFrameList.size();
        System.out.println("Number of IFrame present: " + iframeNumber);


//        withAction().pause(Duration.ofSeconds(5)).perform();


    }


}
