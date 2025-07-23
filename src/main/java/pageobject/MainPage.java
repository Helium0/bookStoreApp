package pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private SelenideElement applicationNameTitle = $(By.xpath("//p[@class='main-title']/a"));


    public boolean verifyAppTextName() {
        return applicationNameTitle.getText().trim().equals("Test App") ? true : false;
    }
}
