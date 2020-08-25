package com.philnguyen.litanime.web;

import com.philnguyen.litanime.dto.OrderDto;
import com.philnguyen.litanime.model.Order;
import com.philnguyen.litanime.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    public ResponseEntity<?> createNewOrder(@RequestBody OrderDto orderDto) {
        Order order = orderService.createNewOrder(orderDto.getProducts());

        return ResponseEntity.ok(order);
    }
}
