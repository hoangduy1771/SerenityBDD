package webelements;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;


@RunWith(SerenityRunner.class)
public class HandlingResizable extends PageObject {

    @Managed
    WebDriver driver;

    @Test
    public void handlingSlider() {
        openUrl("https://demoqa.com/resizable");

        withAction().dragAndDropBy(find(By.xpath("//div[contains(text(), 'Resizable box,')]/following-sibling::span[@class='react-resizable-handle react-resizable-handle-se']")), 300, 500).perform();



        withAction().pause(Duration.ofSeconds(5)).perform();


    }


}
