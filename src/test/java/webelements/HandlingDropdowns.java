package webelements;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

@RunWith(SerenityRunner.class)
public class HandlingDropdowns extends PageObject {

    @Managed
    WebDriver driver;

    @Test
    public void dropDownElementHandling() {
        openUrl("https://www.wikipedia.org/");

        find(By.id("searchLanguage")).selectByVisibleText("Tiếng Việt");
        ArrayList<WebElementFacade> optionValues = findAll(By.xpath("//select[@id='searchLanguage']/option"));

        System.out.println("Start printing every language options.");
        System.out.println("=====================================");

        for (int index = 0; index < optionValues.size(); index++) {
            String language = optionValues.get(index).getText();
            System.out.println(language);

        }
        System.out.println(String.format("There are %s languages options.", optionValues.size()));

        System.out.println("=====================================");
        System.out.println("All language options printed.");


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
