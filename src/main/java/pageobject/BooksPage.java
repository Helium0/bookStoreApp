package pageobject;

import com.codeborne.selenide.SelenideElement;
import common.AppStructureNames;
import common.CommonStructure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BooksPage extends MainPage {

    private static AppStructureNames names = new AppStructureNames();
    private static CommonStructure commonStructure = new CommonStructure();
    private static final Logger logger = LogManager.getLogger(names.getSHOP_NAME());


    private SelenideElement selenideElement(String bookTitle) {
       return $(By.xpath(String.format("//ul[@class='products columns-4']//*[contains(@class,'product__title') " +
               "and contains(text(),'%s')]/ancestor::a/following-sibling::a",bookTitle)));
    }


   public SelenideElement userSearchBookAndAddToCart(String bookTitle) {
        SelenideElement userBook = selenideElement(bookTitle);
        if(userBook.exists()) {
            userBook.click();
            logger.info("User clicked button: "+ commonStructure.getADD_TO_CART_BUTTON());
            logger.info("Book: " + bookTitle + " has been added to cart");
        } else {
            logger.error("Couldn`t find this book title: " + bookTitle);
        }
        return userBook;
   }
}
