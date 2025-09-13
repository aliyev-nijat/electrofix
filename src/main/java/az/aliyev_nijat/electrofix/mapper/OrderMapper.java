package az.aliyev_nijat.electrofix.mapper;

import az.aliyev_nijat.electrofix.model.dto.request.OrderCreateRequest;
import az.aliyev_nijat.electrofix.model.dto.response.OrderResponse;
import az.aliyev_nijat.electrofix.model.entity.OrderEntity;
import az.aliyev_nijat.electrofix.model.entity.OrderStatusEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderEntity mapToEntity(final OrderCreateRequest source, OrderStatusEntity status) {
        return OrderEntity
                .builder()
                .clientName(source.getClientName())
                .clientContact(source.getClientContact())
                .thingName(source.getThingName())
                .note(source.getNote())
                .status(status)
                .build();
    }

    public OrderResponse mapToResponse(final OrderEntity source) {
        return OrderResponse
                .builder()
                .id(source.getId())
                .clientName(source.getClientName())
                .clientContact(source.getClientContact())
                .thingName(source.getThingName())
                .note(source.getNote())
                .status(source.getStatus().getStatus())
                .build();
    }
}
