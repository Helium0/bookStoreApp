package stepsDefinitions;

import io.cucumber.java.en.And;
import pageobject.CheckoutUserPage;

public class CheckoutUserPageSteps {

    private final CheckoutUserPage checkoutUserPage = new CheckoutUserPage();


    @And("User sets name: {} and surname: {}")
    public void userSetsNameAndSurname(String userName, String userLastName) {
        checkoutUserPage.setUserDetails(userName,userLastName);
    }

    @And("User sets address details: {} {} {}")
    public void userSetsAddressDetails(String userStreetName, String userPostCode, String userCity) {
        checkoutUserPage.setUserAddressDetails(userStreetName,userPostCode,userCity);
    }

    @And("User sets contact details: {} {}")
    public void userSetsContactDetails(String userPhone, String userEmail) {
        checkoutUserPage.setUserContactDetails(userPhone,userEmail);
    }

    @And("User sets country {}")
    public void userSetsCountry(String userCountry) {
        checkoutUserPage.findUserCountry(userCountry);
    }

    @And("User sets state {}")
    public void userSetsState(String userState) {
        checkoutUserPage.findUserState(userState);
    }
}
