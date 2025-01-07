package steps;

import net.serenitybdd.annotations.Step;
import pages.HomePage9gag;

public class HomePage9gagSteps {

    HomePage9gag home9gag;

    @Step("Performing navigate")
    public void userNavigateTo(String url) {
        home9gag.navigateTo(url);
    }

    @Step("Click on button or link")
    public void userClickOnButtonOrLink(String buttonText) {
        home9gag.click(buttonText);
    }

    @Step("Enter username")
    public void userEnterUsername(String username) {
        home9gag.enterUsername(username);
    }

    @Step("Enter password")
    public void userEnterPassword(String password) {
        home9gag.enterPassword(password);
    }

    @Step("Verify button state")
    public void userVerifyButtonState(boolean stateExpected, String buttonText) {
        home9gag.verifyButtonEnabled(stateExpected, buttonText);
    }




}
