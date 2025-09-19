package az.aliyev_nijat.electrofix.model.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class OrderResponse {

    private Long id;
    private String clientName;
    private String clientContact;
    private String thingName;
    private String note;
    private String status;
    private Double totalAmount;
    private Double payedAmount;
}
