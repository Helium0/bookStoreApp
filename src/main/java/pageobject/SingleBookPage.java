package pageobject;

import com.codeborne.selenide.SelenideElement;
import common.AppStructureNames;
import common.CommonStructure;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SingleBookPage {

    private static AppStructureNames names = new AppStructureNames();
    private static CommonStructure commonStructure = new CommonStructure();

    private SelenideElement bookTitleElement = $(By.xpath("//div[contains(@class,'entry-summary')]/h1"));
}
