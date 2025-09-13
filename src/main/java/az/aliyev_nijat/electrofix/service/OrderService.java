package az.aliyev_nijat.electrofix.service;

import az.aliyev_nijat.electrofix.exception.StatusNotExistException;
import az.aliyev_nijat.electrofix.mapper.OrderMapper;
import az.aliyev_nijat.electrofix.model.dto.request.OrderCreateRequest;
import az.aliyev_nijat.electrofix.model.dto.response.OrderResponse;
import az.aliyev_nijat.electrofix.model.entity.OrderEntity;
import az.aliyev_nijat.electrofix.model.entity.OrderStatusEntity;
import az.aliyev_nijat.electrofix.repository.OrderRepository;
import az.aliyev_nijat.electrofix.repository.OrderStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository repository;
    private final OrderStatusRepository statusRepository;
    private final OrderMapper mapper;

    public List<OrderResponse> getAll() {
        return repository
                .findAll()
                .stream()
                .map(mapper::mapToResponse)
                .toList();
    }

    public OrderResponse create(OrderCreateRequest request) {
        request.setStatus(request.getStatus().toLowerCase());
        OrderStatusEntity status = statusRepository
                .findByStatus(request.getStatus())
                .orElseThrow(StatusNotExistException::new);

        OrderEntity inputEntity = mapper.mapToEntity(request, status);
        OrderEntity result = repository.save(inputEntity);

        return mapper.mapToResponse(result);
    }

    public List<String> getStatusList() {
        return statusRepository
                .findAll()
                .stream()
                .map(OrderStatusEntity::getStatus)
                .toList();
    }
}
