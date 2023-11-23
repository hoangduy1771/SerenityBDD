package testcases;

import net.serenitybdd.annotations.*;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.HomePage9gagSteps;
import steps.HomePageSteps;
import utils.ExcelReader;

import java.util.Arrays;
import java.util.Collection;

@Narrative(text={"In order to run parameterized test",
        "As a Serenity Runner",
        "We need to Integrate Excel Reading"})
@RunWith(SerenityParameterizedRunner.class)
@Concurrent(threads = "4")
public class Parameterization {

    private final String username;
    private final String password;

    public Parameterization(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @TestData
    public static Collection<Object[]> testData() {

        ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\data\\excel\\usernamepassword.xlsx");
        String sheetName = "Sheet1";
        int rows = excel.getRowCount(sheetName);
        int cols = excel.getColumnCount(sheetName);
        System.out.println("row count: " + rows);
        System.out.println("cols count: " + cols);

        System.out.println("cell read: " + excel.getCellData(sheetName, 0, 2));

        Object[][] data = new Object[rows-1][cols];

//        data[0][0] = excel.getCellData(sheetName, 0, 2);
//        data[0][1] = excel.getCellData(sheetName, 1, 2);
//
//        data[1][0] = excel.getCellData(sheetName, 0, 3);
//        data[1][1] = excel.getCellData(sheetName, 1, 3);

        for (int rowNum = 2; rowNum <= rows; rowNum++) {
            for (int colNum = 0; colNum < cols; colNum++) {
                data[rowNum-2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
            }
        }

        return Arrays.asList(data);
    }

//    make another step page to login something else than gmail

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    HomePage9gagSteps homepage9gagSteps;

    @Title("Executing test")
    @Test
    public void TC0001_loginTo9gag() {
        homepage9gagSteps.userNavigateTo("https://9gag.com/");
        homepage9gagSteps.userClickOnButtonOrLink("Sign Up/Log In");
        homepage9gagSteps.userClickOnButtonOrLink("Already a member? Log in");
        homepage9gagSteps.userEnterUsername(username);
        homepage9gagSteps.userEnterPassword(password);
        homepage9gagSteps.userVerifyButtonState(true, "Log in");

    }

}


