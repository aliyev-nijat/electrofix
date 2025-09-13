package az.aliyev_nijat.electrofix.controller;

import az.aliyev_nijat.electrofix.model.dto.request.OrderCreateRequest;
import az.aliyev_nijat.electrofix.model.dto.response.OrderResponse;
import az.aliyev_nijat.electrofix.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api/order")
@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService service;

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<OrderResponse> create(
            @RequestBody @Valid OrderCreateRequest body
    ) {
        return ResponseEntity.ok(service.create(body));
    }

    @GetMapping("/statuses")
    public ResponseEntity<List<String>> getStatusList() {
        return ResponseEntity.ok(service.getStatusList());
    }
}
