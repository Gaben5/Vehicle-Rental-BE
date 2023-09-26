package com.kodilla.rental.controller;

import com.kodilla.rental.domain.Order;
import com.kodilla.rental.domain.OrderDto;
import com.kodilla.rental.exception.OrderNotFoundException;
import com.kodilla.rental.exception.UserNotFoundException;
import com.kodilla.rental.mapper.OrderMapper;
import com.kodilla.rental.service.OrderDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/order")
public class OrderController {
    private final OrderMapper mapper;
    private final OrderDbService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createOrder(@RequestBody OrderDto orderDto) throws UserNotFoundException {
        Order order = mapper.mapToOrder(orderDto);
        service.saveOrder(order);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{orderId}")
    public ResponseEntity<Void> removeOrder(@PathVariable long orderId) throws OrderNotFoundException {
        service.deleteOrder(orderId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{orderId}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable Long orderId) throws OrderNotFoundException {
        return ResponseEntity.ok(mapper.mapToOrderDto(service.getOrder(orderId)));
    }
}
