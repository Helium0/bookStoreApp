package utils;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Order {

    private String order_item_id;
    private String order_item_name;
    private String order_item_type;
    private String order_id;
}
