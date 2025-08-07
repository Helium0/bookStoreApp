package stepsDefinitions;

import common.AppStructureNames;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageobject.MainPage;

public class SearchFinderPageSteps {

    private final MainPage mainPage = new MainPage();
    private static AppStructureNames names = new AppStructureNames();
    private static final Logger logger = LogManager.getLogger(names.getAPP_NAME());

    @Given("User searchs book title: {}")
    public void bookSearch(String bookTitle) {

    }
}
