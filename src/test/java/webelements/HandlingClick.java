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
public class HandlingClick extends PageObject {

    @Managed
    WebDriver driver;

    @Test
    public void handlingClick() {
        openUrl("https://demoqa.com/buttons");

        withAction().contextClick(find(By.id("rightClickBtn"))).perform();

        String successMessage = find(By.id("rightClickMessage")).getText();
        System.out.println(successMessage);

//        withAction().pause(Duration.ofSeconds(5)).perform();


    }


}
