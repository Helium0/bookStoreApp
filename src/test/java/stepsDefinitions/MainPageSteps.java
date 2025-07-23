package stepsDefinitions;

import common.AppStructureNames;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageobject.MainPage;

import static org.junit.Assert.assertTrue;

public class MainPageSteps {

    private final MainPage mainPage = new MainPage();
    private static AppStructureNames names = new AppStructureNames();
    private static final Logger logger = LogManager.getLogger(names.getAPP_NAME());


    @Given("User checks if logged on correct website")
    public void open() {
        logger.info("Checking website title");
        assertTrue("Website name is different", mainPage.verifyAppTextName());
    }
}
