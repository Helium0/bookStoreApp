package common;

import lombok.Getter;

@Getter
public class AppStructureNames {

    private final String BROWSER_NAME = "[CHROME]";
    private final String APP_NAME = "[TEST_APP] ";
    private final String SHOP_NAME = APP_NAME + "[SHOP]";
    private final String CART_NAME = APP_NAME + "[CART]";
    private final String DATA_BASE = APP_NAME + "[DATA-BASE]";
    private final String USER_CARD = "[CARD]";
    private final String USER = "[USER]";
    private final String USER_BILLING_DETAILS = USER + " [BILLING-DETAILS]";
    private final String ORDER = APP_NAME + "[ORDER-DETAILS]";
    private final String FINAL_PAGE = APP_NAME + "[ORDER-RECEIVED]";
    private final String LOGIN_USER = APP_NAME + "[LOGIN]";

}
