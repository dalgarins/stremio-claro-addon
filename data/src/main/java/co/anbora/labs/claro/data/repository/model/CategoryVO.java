package co.anbora.labs.claro.data.repository.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CategoryVO {

    private String filterId;
    private String from;
    private String quantity;
    private String levelId;
    private String orderWay;
    private String orderId;
    private String region;

    public boolean hasValidFilterId() {
        return filterId != null && !filterId.isEmpty();
    }

}
