package dao;

import lombok.AllArgsConstructor;
import utils.StripeCard;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class CardDAO implements StripeCardDAO {

    private final DataSource dataSource;
    

    @Override
    public List<StripeCard> getAll() {
        String allCardsSQLCommand = "SELECT * FROM wp_stripe_cards";
        List<StripeCard> cards = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(allCardsSQLCommand)) {
            while (resultSet.next()) {
                StripeCard stripeCard = StripeCard.builder()
                        .card_name(resultSet.getString("cardName"))
                        .card_number(resultSet.getString("cardNumber"))
                        .exp_date(resultSet.getString("expiryDate"))
                        .cvv(resultSet.getString("cvv"))
                        .build();
                cards.add(stripeCard);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error when get cards", e);
        }
        return cards;
    }
}
