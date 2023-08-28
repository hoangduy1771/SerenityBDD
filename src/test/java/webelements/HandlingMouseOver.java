package webelements;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


@RunWith(SerenityRunner.class)
public class HandlingMouseOver extends PageObject {

    @Managed
    WebDriver driver;

    @Test
    public void mouseOver() {
        openUrl("https://demoqa.com/");
        find(By.xpath("//div//h5[text()='Widgets']")).click();
        waitForCondition().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='main-header' and text()='Widgets']")));
        find(By.xpath("//span[text()='Tool Tips']")).click();
        waitForCondition().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='Practice Tool Tips']")));

        withAction().moveToElement($("//button[text()='Hover me to see']")).perform();
        String hoveredText = find(By.xpath("//*[text()='You hovered over the Button']")).getText();
        System.out.println(hoveredText);
    }


}
