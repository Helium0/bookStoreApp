package pageobject;

import com.codeborne.selenide.SelenideElement;
import common.AppStructureNames;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private AppStructureNames names = new AppStructureNames();
    private Logger logger = LogManager.getLogger(names.getAPP_NAME());


    private SelenideElement applicationNameTitle = $(By.xpath("//p[@class='main-title']/a"));
    private final SelenideElement navigationBarElement(String userChoice) {
        return  $(By.xpath(String.format("//div[@id='primary-menu']//li[contains(@class,'menu-item')]/a[text()='%s']", userChoice)));
    }


    public boolean verifyAppTextName() {
        return applicationNameTitle.getText().trim().equals("Test App") ? true : false;
    }

    public void clickOnCorrectNavigationBarElement(String userChoice) {
        if(navigationBarElement(userChoice).isDisplayed()) {
            navigationBarElement(userChoice).click();
            logger.info("Clicked on: " + userChoice);
        } else {
            logger.error("Couldn`t click on: " + userChoice);
        }
    }
}
