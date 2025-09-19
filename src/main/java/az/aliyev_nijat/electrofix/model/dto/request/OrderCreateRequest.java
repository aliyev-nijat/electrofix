package az.aliyev_nijat.electrofix.model.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderCreateRequest {

    @Pattern(
            regexp = "^(?!.* {2})(?! ).+(?<! )$",
            message = "{orderCreateRequest.clientName.pattern}")
    private String clientName;

    @Pattern(regexp = "^[0-9+]+$", message = "{orderCreateRequest.clientContact.pattern}")
    private String clientContact;

    @NotNull(message = "{orderCreateRequest.thingName.notNull}")
    @Pattern(regexp = "^(?! )(?!.* {2})(?!.* $).+$", message = "{orderCreateRequest.thingName.pattern}")
    private String thingName;
    private String note;

    @Pattern(regexp = "^(?! )(?!.* {2})(?!.* $).+$", message = "{orderCreateRequest.status.pattern}")
    @NotNull(message = "{orderCreateRequest.status.notNull}")
    private String status;

    @PositiveOrZero(message = "{orderCreateRequest.totalAmount.positiveOrZero}")
    private Double totalAmount;

    @NotNull(message = "{orderCreateRequest.payedAmount.notNull}")
    @PositiveOrZero(message = "{orderCreateRequest.payedAmount.positiveOrZero}")
    private Double paidAmount;
}
