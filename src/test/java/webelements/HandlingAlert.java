package webelements;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;


@RunWith(SerenityRunner.class)
public class HandlingAlert extends PageObject {

    @Managed
    WebDriver driver;

    @Test
    public void handlingAlert() {
        openUrl("https://demoqa.com/alerts");

//        button for alert
        WebElement btnAlert = find(By.xpath("//button[@id='alertButton']"));
        btnAlert.click();
//        withAction().pause(Duration.ofSeconds(1)).perform();

        Alert alert = getAlert();
        String alertText = alert.getText();
        alert.accept();
        System.out.println(alertText);

//        withAction().pause(Duration.ofSeconds(5)).perform();


    }


}
