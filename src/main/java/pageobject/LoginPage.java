package pageobject;

import com.codeborne.selenide.SelenideElement;
import common.AppStructureNames;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertEquals;

public class LoginPage {

    private AppStructureNames names = new AppStructureNames();
    private Logger logger = LogManager.getLogger(names.getAPP_NAME());


    private final SelenideElement logInButton = $(By.name("login"));
//    private final SelenideElement loginErrorElement = $(By.xpath("//ul[@class='woocommerce-error']/li[contains(normalize-space(),'Username is required.')]"))
    private final SelenideElement loginErrorElement = $(By.xpath("//ul[@class='woocommerce-error']/li"));

    public void clickOnLogInButton() {
        logInButton.click();
    }

    private HashMap<String,String> errorsHashMap() {
        HashMap<String,String> myMap = new HashMap<>();
        myMap.put("Error", loginErrorElement.getText());
        return myMap;
    }

    public void ooo() {
       for (Map.Entry<String,String> ok : errorsHashMap().entrySet()) {
           if(ok.getValue().contains("Username is required")) {
               logger.info("Valid error showed up");
           } else {
               logger.error("Couldn`t find this error");
           }
       }
    }

}
