package dao;

import utils.Order;

import java.sql.SQLException;

public interface StripeOrderDAO {

    Order deleteOrderById(String userOrderId) throws SQLException;

    Order getOrderById(String userOrderId) throws SQLException;
}
