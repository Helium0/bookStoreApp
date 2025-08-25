package dao;

import lombok.AllArgsConstructor;
import utils.Order;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


@AllArgsConstructor
public class OrderDAO implements StripeOrderDAO {

    private final DataSource dataSource;

    @Override
    public Order deleteOrderById(String userOrderId) throws SQLException {
        String getOrder = "DELETE FROM wordpress.wp_woocommerce_order_items " +
                "WHERE order_id = " + userOrderId;
        try (Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement()) {
            statement.executeUpdate(getOrder);
        }
        return null;
    }

    @Override
    public Order getOrderById(String userOrderId) throws SQLException {
        String getOrder = "SELECT * FROM wp_woocommerce_order_items WHERE order_id = " + userOrderId;
        try (Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(getOrder)) {
            if (resultSet.next()) {
                return Order.builder()
                        .order_id(resultSet.getString("order_id"))
                        .order_item_name(resultSet.getString("order_item_name"))
                        .build();
            }
        }
        return null;
    }
}
