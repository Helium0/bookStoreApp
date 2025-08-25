package pageobject;

import com.codeborne.selenide.SelenideElement;
import common.AppStructureNames;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import java.util.HashMap;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private AppStructureNames names = new AppStructureNames();
    private Logger logger = LogManager.getLogger(names.getAPP_NAME());


    private final SelenideElement logInButton = $(By.name("login"));
    private final SelenideElement loginErrorElement = $(By.xpath("//ul[@class='woocommerce-error']/li"));

    public void clickOnLogInButton() {
        logInButton.click();
    }

    public HashMap<String,String> errorsHashMap() {
        HashMap<String,String> myMap = new HashMap<>();
        myMap.put("Error", loginErrorElement.getText());
        return myMap;
    }
}
