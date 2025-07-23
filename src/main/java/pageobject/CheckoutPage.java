package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.google.protobuf.Empty;
import dao.CardDAO;
import mysql.DataBaseConfiguration;
import org.openqa.selenium.By;
import utils.StripeCard;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class CheckoutPage {

    private final CardDAO cardDAO = new CardDAO(DataBaseConfiguration.getDataSource());
    private StripeCard stripeCard;
    private SelenideElement selenideElement = $(By.xpath("//div[@id='stripe-card-element']//iframe[contains(@name,'privateStripe')]"));
    private SelenideElement cardNumberElement = $(By.xpath("//input[@name='cardnumber']"));
    private SelenideElement expiryDateIframe = $(By.xpath("//div[@id='stripe-exp-element']//iframe[contains(@name,'privateStripe')]"));
    private SelenideElement expiryDateElement = $(By.xpath("//input[@name='exp-date']"));
    private SelenideElement cvvDateIframe = $(By.xpath("//div[@id='stripe-cvc-element']//iframe[contains(@name,'privateStripe')]"));
    private SelenideElement cvvElement = $(By.xpath("//input[@name='cvc']"));

    public void switchIframe() throws InterruptedException {
        switchTo().frame(selenideElement);
        cardNumberElement.setValue(stripeCard.getCARD_NUMBER()).shouldNot(Condition.empty);
        switchTo().defaultContent();
        switchExp();
        switchTo().defaultContent();
        switchCVV();
    }

    public void switchExp() {
        switchTo().frame(expiryDateIframe);
        expiryDateElement.setValue(stripeCard.getEXP_DATE()).shouldNot(Condition.empty);
    }

    public void switchCVV() {
        switchTo().frame(cvvDateIframe);
        cvvElement.setValue(stripeCard.getCVV());
    }

    public StripeCard kk() {
        for (StripeCard k : cardDAO.getAll()) {
            if(k.getCARD_NAME().equals("UnionPay")) {
                k.setCARD_NAME(k.getCARD_NAME());
                k.setCARD_NUMBER(k.getCARD_NUMBER());
                k.setEXP_DATE(k.getEXP_DATE());
                k.setCVV(k.getCVV());
                this.stripeCard = k;
                return k;
            }
        }
       return null;
    }








}
