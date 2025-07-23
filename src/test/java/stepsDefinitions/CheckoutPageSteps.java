package stepsDefinitions;

import common.AppStructureNames;
import io.cucumber.java.en.And;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageobject.CheckoutPage;

import java.sql.SQLException;

public class CheckoutPageSteps {

    private static AppStructureNames names = new AppStructureNames();
    private final CheckoutPage checkoutPage = new CheckoutPage();
    private static final Logger logger = LogManager.getLogger(names.getCART_NAME());

    @And("Card")
    public void card() throws SQLException {
        logger.info("OOOOOK");
        System.out.println(checkoutPage.kk());

    }

    @And("Fill")
    public void fill() throws InterruptedException {
        logger.info("YES");
        checkoutPage.switchIframe();
        Thread.sleep(4000);
    }
}
