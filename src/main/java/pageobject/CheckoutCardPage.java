package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import common.AppStructureNames;
import dao.CardDAO;
import mysql.DataBaseConfiguration;
import org.openqa.selenium.By;
import utils.StripeCard;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class CheckoutCardPage {

    private final CardDAO cardDAO = new CardDAO(DataBaseConfiguration.getDataSource());
    private final AppStructureNames names = new AppStructureNames();
    private final Logger logger = LogManager.getLogger(names.getUSER_CARD());
    private StripeCard stripeCard;
    private final SelenideElement selenideElement = $(By.xpath("//div[@id='stripe-card-element']//iframe[contains(@name,'privateStripe')]"));
    private final SelenideElement cardNumberElement = $(By.xpath("//input[@name='cardnumber']"));
    private final SelenideElement expiryDateIframe = $(By.xpath("//div[@id='stripe-exp-element']//iframe[contains(@name,'privateStripe')]"));
    private final SelenideElement expiryDateElement = $(By.xpath("//input[@name='exp-date']"));
    private final SelenideElement cvvDateIframe = $(By.xpath("//div[@id='stripe-cvc-element']//iframe[contains(@name,'privateStripe')]"));
    private final SelenideElement cvvElement = $(By.xpath("//input[@name='cvc']"));
    private final SelenideElement placeOrderButton = $(By.id("place_order"));

    public void fillCardDetails() {
        switchTo().frame(selenideElement);
        cardNumberElement.setValue(stripeCard.getCard_number());
        switchTo().defaultContent();
        switchIframeForCardExpiryDate();
        switchTo().defaultContent();
        switchIframeForCardCVV();
    }

    private void switchIframeForCardExpiryDate() {
        switchTo().frame(expiryDateIframe);
        expiryDateElement.setValue(stripeCard.getExp_date());
    }

    private void switchIframeForCardCVV() {
        switchTo().frame(cvvDateIframe);
        cvvElement.setValue(stripeCard.getCvv());
        switchTo().defaultContent();
    }

    public StripeCard chooseCard(String userCard) {
        logger.info("Searching for particular card from DB");
        for (StripeCard card : cardDAO.getAll()) {
            if(card.getCard_name().equals(userCard)) {
                card.setCard_name(card.getCard_name());
                card.setCard_number(card.getCard_number());
                card.setExp_date(card.getExp_date());
                card.setCvv(card.getCvv());
                this.stripeCard = card;
                logger.info(this.stripeCard);
                return card;
            }
        }
        logger.info((String) null);
       return null;
    }

    public void placeOrderButtonClick() {
        if(placeOrderButton.is(Condition.clickable)) {
            placeOrderButton.click();
            logger.info(placeOrderButton.getText() + " clicked");
        } else {
            logger.info(placeOrderButton.getText() + " not available");
        }
    }
}
