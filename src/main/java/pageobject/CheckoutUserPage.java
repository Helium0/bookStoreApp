package pageobject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import common.AppStructureNames;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CheckoutUserPage {


    private final AppStructureNames names = new AppStructureNames();
    private final Logger logger = LogManager.getLogger(names.getUSER_BILLING_DETAILS());

    private final SelenideElement userNameInput = $(By.id("billing_first_name"));
    private final SelenideElement userLastNameInput = $(By.id("billing_last_name"));
    private final SelenideElement userCountryElement = $(By.id("select2-billing_country-container"));
    private final SelenideElement userStateElement = $(By.id("select2-billing_state-container"));
    private final SelenideElement userStreetNameInput = $(By.id("billing_address_1"));
    private final SelenideElement userPostCodeInput = $(By.id("billing_postcode"));
    private final SelenideElement userCityInput = $(By.id("billing_city"));
    private final SelenideElement userPhoneInput = $(By.id("billing_phone"));
    private final SelenideElement userEmailInput = $(By.id("billing_email"));
    private final ElementsCollection userDropDownList = $$(By.xpath("//span[@class='select2-results']//li"));

    public void setUserDetails(String userName, String userLastName) {
        logger.info("Setting user details");
        userNameInput.setValue(userName);
        userLastNameInput.setValue(userLastName);
    }

    public void setUserAddressDetails(String userStreet, String userPostCode, String userCity) {
        logger.info("Setting user billing details");
        userStreetNameInput.setValue(userStreet);
        userPostCodeInput.setValue(userPostCode);
        userCityInput.setValue(userCity);
    }

    public void setUserContactDetails(String userPhone, String userEmail) {
        logger.info("Setting user contact details");
        userPhoneInput.setValue(userPhone);
        userEmailInput.setValue(userEmail);
    }

    public void findUserCountry(String userCountry) {
        logger.info("Setting user country");
        userCountryElement.click();
        userDropDownList.stream().filter(country -> country.getText().equals(userCountry)).findFirst().orElseThrow().click();
    }

    public void findUserState(String userState) {
        logger.info("Setting user state");
        userStateElement.click();
        userDropDownList.stream().filter(state -> state.getText().equals(userState)).findFirst().orElseThrow().click();
    }


}
