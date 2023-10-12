package webelements;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.pages.components.HtmlTable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


@RunWith(SerenityRunner.class)
public class HandlingScreenshot extends PageObject {

    @Managed
    WebDriver driver;

    @Test
    public void handlingScreenshot() {

        openUrl("https://money.rediff.com/gainers");




        driver.quit();

//        withAction().pause(Duration.ofSeconds(5)).perform();


    }


}
