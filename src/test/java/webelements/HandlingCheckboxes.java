package webelements;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.webelements.Checkbox;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;


@RunWith(SerenityRunner.class)
public class HandlingCheckboxes extends PageObject {

    @Managed
    WebDriver driver;
    Actions action = new Actions(Serenity.getDriver());

    @Test
    public  void checkBoxHandling() {

        openUrl("https://www.booking.com/");

        String dismissButtonXpath = "//button[contains(@aria-label, 'Dismiss sign')]";
        find(By.xpath(dismissButtonXpath)).click();

        Checkbox checkbox = new Checkbox(find(By.xpath("//input[@id=':rf:']")));
        System.out.println("Status of check box 'I'm looking for an entire home or apartment' is: " + checkbox.isChecked());

        checkbox.setChecked(true);
        System.out.println("Status of check box 'I'm looking for an entire home or apartment' is: " + checkbox.isChecked());


        action.pause(Duration.ofSeconds(5)).perform();

    }



}






















