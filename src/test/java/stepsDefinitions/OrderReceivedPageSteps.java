package stepsDefinitions;

import common.AppStructureNames;
import dao.OrderDAO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageobject.OrderReceivedPage;

import javax.sql.DataSource;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static mysql.DataBaseConfiguration.getDataSource;

public class OrderReceivedPageSteps {

    private AppStructureNames names = new AppStructureNames();
    private OrderReceivedPage orderReceivedPage;
    private Logger logger = LogManager.getLogger(names.getFINAL_PAGE());


    public OrderReceivedPageSteps() {
        DataSource dataSource = getDataSource();
        OrderDAO orderDAO = new OrderDAO(dataSource);
        this.orderReceivedPage = new OrderReceivedPage(orderDAO);
    }

    @Then("User successfully placed order")
    public void userSuccessfullyPlacedOrder() {
        logger.info("User is on final page");
        orderReceivedPage.validateOrderConfirmation();
    }

    @And("Checks order in DB")
    public void checksOrderInDB() throws SQLException {
        logger.info("ID: " + orderReceivedPage.getOrder().getOrder_id() + " Title: " + orderReceivedPage.getOrder().getOrder_item_name());
        assertEquals(orderReceivedPage.showOrderNumberId(), orderReceivedPage.getOrder().getOrder_id());
        assertEquals("Title is different", orderReceivedPage.getOrder().getOrder_item_name(), "How to Do Chemical Tricks by A. Anderson");
    }
}
