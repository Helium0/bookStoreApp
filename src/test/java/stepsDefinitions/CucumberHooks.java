package stepsDefinitions;

import com.codeborne.selenide.Selenide;
import common.AppStructureNames;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.codeborne.selenide.Selenide.*;

public class CucumberHooks {

    private static final AppStructureNames names = new AppStructureNames();
    private static final Logger logger = LogManager.getLogger(names.getBROWSER_NAME());

    @Before
    public void openWebsite() {
        logger.info("Opening browser");
        open("http://localhost:8080/");
        Selenide.webdriver().driver().getWebDriver().manage().window().maximize();
    }

    @After
    public void tearDown() {
        logger.info("Closing browser");
        closeWebDriver();
    }
}
