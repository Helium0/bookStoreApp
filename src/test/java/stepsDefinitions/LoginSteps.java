package stepsDefinitions;

import common.AppStructureNames;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageobject.LoginPage;

import static org.junit.Assert.assertEquals;

public class LoginSteps {

    private AppStructureNames names = new AppStructureNames();
    private LoginPage loginPage = new LoginPage();
    private Logger logger = LogManager.getLogger(names.getLOGIN_USER());

    @When("User doesn`t provide any data")
    public void okok() {
        logger.info("User doesn`t provide any data");
    }

    @And("Clicks on Log in button")
    public void ee() {
        loginPage.clickOnLogInButton();
    }

    @Then("User couldn`t log in")
    public void ll() {
        loginPage.ooo();
        assertEquals()
    }

}
