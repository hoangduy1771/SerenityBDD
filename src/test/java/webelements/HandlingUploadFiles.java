package webelements;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@RunWith(SerenityRunner.class)
public class HandlingUploadFiles extends PageObject {

    @Managed
    WebDriver driver;

    @Test
    public void handlingFileUpload() {

        openUrl("https://send-anywhere.com/");

//        find(By.xpath("//div[@class='clickzone border-box large']")).click();
//        Cues for finding upload file element: usually it's an input tag with class type='file'
//        //input[@type='file']
        String filePath = "C:\\Users\\hoang\\Pictures\\Windows Spotlight Images\\072fb8a6-1120-457f-b0e4-6f6549cff278.jpg";
        upload(filePath).to(find(By.xpath("//input[@type='file']")));


        String verifyText = find(By.xpath("//div[@class='files-info']")).getText();
        System.out.println(verifyText);


        driver.quit();

//        withAction().pause(Duration.ofSeconds(5)).perform();


    }


}
