package testcases;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LoginTest extends PageObject {
    @Managed
    WebDriver driver;

    @Title("Execute Serenity Test")
    @Test
    public void doLogin() throws InterruptedException {
        open();
        System.out.println(getTitle());
//        driver.get("https://google.com");

//        -- Using serenity framework methods
//        getDriver().findElement(By.name("q")).sendKeys("Hello");
//        find(By.xpath("//*[@name='q']")).sendKeys("Hello");

//        -- For CSS selector or xpath you can use $
//        $("//*[@name='q']").sendKeys("Hello");
        typeInto($("//*[@name='q']"), "Hello");


        Thread.sleep(2000);

    }

}