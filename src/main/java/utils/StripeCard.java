package utils;

import lombok.Builder;

@Builder
public class StripeCard {


    private final String CARD_NUMBER;
    private final String EXP_DATE;
    private final String CVV;

}
