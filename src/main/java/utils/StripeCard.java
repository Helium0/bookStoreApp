package utils;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StripeCard {


    private  String CARD_NAME;
    private  String CARD_NUMBER;
    private  String EXP_DATE;
    private  String CVV;
}
