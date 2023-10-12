package pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class HomePage extends PageObject {

    public void navigate() {
        openUrl("https://gmail.com/");
    }

    public void enterEmailUsername() {
        find(By.xpath("//input[@type='email']")).sendKeys("hoangduy1772@gmail.com");
    }

    public void clickNextButton() {
        find(By.xpath("//*[contains(text(),'Next')]")).click();
    }

    public void verifyTextExist() {
        waitForCondition().withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(500))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()[normalize-space()='This browser or app may not be secure.']]")));
    }


}



