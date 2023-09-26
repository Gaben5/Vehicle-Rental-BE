package com.kodilla.rental.mapper;

import com.kodilla.rental.domain.Order;
import com.kodilla.rental.domain.OrderDto;
import com.kodilla.rental.exception.UserNotFoundException;
import com.kodilla.rental.service.UserDbService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class OrderMapper {

    private UserDbService userDbService;
    public OrderDto mapToOrderDto(Order order){
        return new OrderDto(order.getId(), order.getCost(), order.getCreated(), order.getDays(), order.getDateFrom(), order.getDateTo(), order.getUser().getId());
    }

    public Order mapToOrder(OrderDto orderDto) throws UserNotFoundException {
        return new Order(orderDto.getId(), orderDto.getCost(), orderDto.getCreated(),
                orderDto.getDays(), orderDto.getDateFrom(), orderDto.getDateTo(),
                userDbService.getUser(orderDto.getUserId()));
    }

    public List<OrderDto> mapToOrderDtoList(final List<Order> orders){
        return orders.stream().map(this::mapToOrderDto).collect(Collectors.toList());
    }
}
