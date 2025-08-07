package pageobject;

import com.codeborne.selenide.SelenideElement;
import common.AppStructureNames;
import common.CommonStructure;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchFinderPage {

    private static AppStructureNames names = new AppStructureNames();
    private static CommonStructure commonStructure = new CommonStructure();

    private SelenideElement searchFinderElement = $(By.cssSelector("#wc-block-search__input-1"));

    public void bookSearch(String book) {
            searchFinderElement.setValue(book).pressEnter();
    }
}
