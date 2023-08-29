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
public class HandlingSlider extends PageObject {

    @Managed
    WebDriver driver;

    @Test
    public void handlingSlider() {
        openUrl("https://demoqa.com/slider");
//        get the center of the slide
        int size = find(By.xpath("//input[@type='range']")).getSize().getWidth()/2;

        String valueBeforeChange = find(By.id("sliderValue")).getAttribute("value");
        System.out.println("Value before change: " + valueBeforeChange);

        withAction().dragAndDropBy(find(By.xpath("//input[@type='range']")), 50, 0).perform();

        String valueAfterChange = find(By.id("sliderValue")).getAttribute("value");
        System.out.println("Value after change: " + valueAfterChange);
        System.out.println(valueAfterChange);


//        withAction().pause(Duration.ofSeconds(5)).perform();



    }


}
