package co.anbora.labs.claro.domain.model.claro;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CategoryVideo {

    private String filterId;
    private String from;
    private String quantity;
    private String levelId;
    private String orderWay;
    private String orderId;
    private String region;

}
