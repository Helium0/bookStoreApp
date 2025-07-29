package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import common.AppStructureNames;
import dao.OrderDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import utils.Order;
import java.sql.SQLException;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class OrderReceivedPage {

    private final OrderDAO orderDAO;
    private AppStructureNames names = new AppStructureNames();
    private Logger logger = LogManager.getLogger(names.getORDER());
    private SelenideElement orderReceivedConfirmation = $(By.xpath("//div[@class='entry-content']//p"));
    private SelenideElement orderNumber = $(By.xpath("//div[@class='woocommerce-order']//li[contains(@class,'__order')]/strong"));

    public OrderReceivedPage(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }


    public void validateOrderConfirmation() {
        orderReceivedConfirmation.should(Condition.visible,Duration.ofSeconds(10));
        if(orderReceivedConfirmation.getText().contains("Your order has been received")) {
            logger.info("Order received successfully");
        } else {
            logger.info("Order failed");
        }
    }

    public String showOrderNumberId() {
        return orderNumber.getText();
    }

    public Order getOrder() throws SQLException {
        String orderId = showOrderNumberId();
        return orderDAO.getOrderById(orderId);
    }
}
