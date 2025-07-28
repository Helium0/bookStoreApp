package stepsDefinitions;

import common.AppStructureNames;
import io.cucumber.java.en.And;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageobject.CheckoutCardPage;

public class CheckoutCardPageSteps {

    private static AppStructureNames names = new AppStructureNames();
    private final CheckoutCardPage checkoutPage = new CheckoutCardPage();
    private static final Logger logger = LogManager.getLogger(names.getCART_NAME());

    @And("User wants to pay with {}")
    public void card(String userCard) {
        logger.info("User pays with: " + userCard);
        checkoutPage.chooseCard(userCard);
        checkoutPage.fillCardDetails();
        checkoutPage.placeOrderButtonClick();
    }

    @And("User fills card details and place order")
    public void userFillsCardDetailsAndPlaceOrder() {
        logger.info("User set remaining data and place order");
        checkoutPage.fillCardDetails();
        checkoutPage.placeOrderButtonClick();
    }
}
