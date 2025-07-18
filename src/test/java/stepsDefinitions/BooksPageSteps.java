package stepsDefinitions;

import common.AppStructureNames;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageobject.BooksPage;

import static org.testng.Assert.*;

public class BooksPageSteps {

    private final BooksPage booksPage = new BooksPage();
    private static AppStructureNames names = new AppStructureNames();
    private static final Logger logger = LogManager.getLogger(names.getSHOP_NAME());




    @Then("User search {} book and add to cart")
    public void userSearchBookAndAddToCart(String bookTitle) {
        logger.info("Searching book title: "+ bookTitle);
        assertTrue(booksPage.userSearchBookAndAddToCart(bookTitle).exists(), "This book title doesn`t exist");
    }
}
