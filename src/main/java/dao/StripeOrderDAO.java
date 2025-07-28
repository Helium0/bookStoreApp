package dao;

import utils.Order;

import java.sql.SQLException;

public interface StripeOrderDAO {

    default Order deleteOrderById() {
        return null;
    }

    Order getOrderById(String userOrderId) throws SQLException;
}
