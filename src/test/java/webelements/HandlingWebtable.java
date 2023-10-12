package webelements;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.pages.components.HtmlTable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


@RunWith(SerenityRunner.class)
public class HandlingWebtable extends PageObject {

    @Managed
    WebDriver driver;

    @Test
    public void handlingWebTable() {

        openUrl("https://money.rediff.com/gainers");

////        method 1
////        perform print all the row in table - tr
//        WebElementFacade table = find(By.xpath("//table[@class='dataTable']"));
//        List<WebElementFacade> rows = table.thenFindAll(By.tagName("tr"));
//
//        System.out.println(rows.size());
//
//        for (WebElementFacade row : rows) {
//            System.out.println(row.getText());
//        }
//
////        print all data of one row
////        find column count of table - find all the table header - th
//        WebElementFacade row = find(By.xpath("//table[@class='dataTable']/thead/tr"));
//        List<WebElementFacade> cols = row.thenFindAll(By.tagName("th"));
//        System.out.println("Total columns are: " + cols.size());
//
////        print all table header
//        for (WebElementFacade col: cols) {
//            System.out.println(col.getText());
//        }


//        method 2 - using HtmlTable serenity class
        HtmlTable tableSerenity = new HtmlTable(find(By.xpath("//table[@class='dataTable']")));
        List<String> headers = tableSerenity.getHeadings();

        System.out.println("Printing all the headers");
        for (String header: headers) {
            System.out.println(header);
        }

        List<WebElement> rows = tableSerenity.getRowElements();

        System.out.println("========================");
        System.out.println("Printing all the row data");
        for (WebElement row: rows) {
            System.out.println(row.getText());
        }


        driver.quit();

//        withAction().pause(Duration.ofSeconds(5)).perform();


    }


}
