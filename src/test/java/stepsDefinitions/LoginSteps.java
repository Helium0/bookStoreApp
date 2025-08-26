package stepsDefinitions;

import common.AppStructureNames;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageobject.LoginPage;
import java.util.Map;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

public class LoginSteps {

    private AppStructureNames names = new AppStructureNames();
    private LoginPage loginPage = new LoginPage();
    private Logger logger = LogManager.getLogger(names.getLOGIN_USER());

    @When("User doesn`t provide any data")
    public void okok() {
        logger.info("User doesn`t provide any data");
    }

    @When("User provided credentials {} and {}")
    public void provideLoginCredentials(String usernameOrEmail, String password) {
        logger.info("User provides credentials");
        loginPage.provideLoginCredentials(usernameOrEmail,password);
    }

    @And("Clicks on Log in button")
    public void clickOnLogInButton() {
        logger.info("User clicks on Log in button");
        loginPage.clickOnLogInButton();
    }

    @Then("User couldn`t log in")
    public void errorsHashMap() {
        logger.info("Validate error message");
        Map<String,String> errors = loginPage.errorsHashMap();
        assertFalse("No displayed errors", errors.isEmpty());
        boolean hasUserNameError = errors.values().stream()
                .anyMatch(error -> error.contains("Username is required.")
                || error.contains("try your email address instead.")
                || error.contains("Unknown email address"));
        assertTrue("Expected error: Username is required. but received: " + errors, hasUserNameError);
       }
}
