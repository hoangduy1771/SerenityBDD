package steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import pages.HomePage;

public class HomePageSteps {

    HomePage home;

    @Step("Performing login")
    public void userLoginToGmail() {
        home.navigate();
        home.enterEmailUsername();
        home.clickNextButton();

    }

    @Step("Verify text")
    public void verifyText() {
        home.verifyTextExist();
        Serenity.takeScreenshot();
    }

}









