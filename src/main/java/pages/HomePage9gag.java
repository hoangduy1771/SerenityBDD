package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage9gag extends PageObject {

    public void navigateTo(String url) {
        openUrl(url);
    }

    public void click(String buttonText) {
        String xpathBtn = String.format("//*[self::button or self::a][normalize-space(text())='%s']", buttonText);
        WebElementFacade button = find(By.xpath(xpathBtn));
        button.click();
    }

    public void enterUsername(String username) {
        find(By.xpath("//input[@name='username']")).sendKeys(username);
    }

    public void enterPassword(String password) {
        find(By.xpath("//input[@name='password']")).sendKeys(password);
    }

    public void verifyButtonEnabled(boolean buttonStateExpected, String buttonText) {
        String xpathBtn = String.format("//*[self::button or self::a][normalize-space(text())='%s']", buttonText);
        WebElement targetButton = find(By.xpath(xpathBtn));
        Assert.assertEquals(
                "Error: Button state expected: " + buttonStateExpected + " Button state actual: " + targetButton.isEnabled()
                , buttonStateExpected, targetButton.isEnabled());

    }

}
