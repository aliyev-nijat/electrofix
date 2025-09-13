package az.aliyev_nijat.electrofix.model.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class OrderResponse {

    private Long id;
    private String clientName;
    private String clientContact;
    private String thingName;
    private String note;
    private String status;
}
