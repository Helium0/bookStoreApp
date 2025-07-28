package utils;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StripeCard {

    private String card_name;
    private String card_number;
    private String exp_date;
    private String cvv;
}
