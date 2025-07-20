package utils;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StripeCard {


    private final String CARD_NAME;
    private final int CARD_NUMBER;
    private final String EXP_DATE;
    private final int CVV;
}
