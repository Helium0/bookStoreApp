package pageobject;

import com.codeborne.selenide.SelenideElement;
import common.AppStructureNames;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    private static AppStructureNames names = new AppStructureNames();
    private static final Logger logger = LogManager.getLogger(names.getSHOP_NAME());


    private SelenideElement cartTitleText = $(By.xpath("//h2[contains(@class,'cart__title')]"));
    private SelenideElement goToCheckoutButton = $(By.xpath("//a[contains(@class,'footer-checkout')]"));

    public int checkItemsInCart() {
        String [] table = cartTitleText.getText().split(" ");
        String example = table[2].substring(1);
        logger.info("Items in cart: " + example);
        return Integer.parseInt(example);
        }

    public void clickGoToCheckoutButton() {
        goToCheckoutButton.click();
    }
}



