package stepsDefinitions;

import common.AppStructureNames;
import io.cucumber.java.en.And;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageobject.CartPage;
import static org.testng.Assert.*;

public class CartPageSteps {


    private static AppStructureNames names = new AppStructureNames();
    private final CartPage cartPage = new CartPage();
    private static final Logger logger = LogManager.getLogger(names.getCART_NAME());



    @And("User checks how many books in cart: {int}")
    public void userChecksHowManyBooksInCart(int itemNumber) {
        logger.info("User checks how many books in cart");
        assertEquals(cartPage.checkItemsInCart(), itemNumber, "Different quantity in cart");
    }

    @And("User go to checkout")
    public void userGoToCheckout() {
        logger.info("User clicks on checkout button");
        cartPage.clickGoToCheckoutButton();
    }
}
