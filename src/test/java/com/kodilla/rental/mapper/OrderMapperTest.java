package com.kodilla.rental.mapper;

import com.kodilla.rental.domain.Order;
import com.kodilla.rental.domain.OrderDto;
import com.kodilla.rental.domain.User;
import com.kodilla.rental.exception.UserNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderMapperTest {
    @Autowired
    OrderMapper orderMapper;

    @Test
    void mapToOrderDto() {
        //Given
        Order order = new Order(1L, new BigDecimal(200), LocalDate.of(2023, 5, 12), 5, LocalDate.of(2023, 5, 12),LocalDate.of(2023, 5, 17), new User());
        //When
        OrderDto orderDto = orderMapper.mapToOrderDto(order);
        //Then
        assertEquals(order.getId(), orderDto.getId());
        assertEquals(order.getCost(), orderDto.getCost());
        assertEquals(order.getCreated(), orderDto.getCreated());
        assertEquals(order.getDays(), orderDto.getDays());
        assertEquals(order.getDateFrom(), orderDto.getDateFrom());
        assertEquals(order.getDateTo(), orderDto.getDateTo());
    }

    @Test
    void mapToOrder() throws UserNotFoundException {
        //Given
        OrderDto orderDto = new OrderDto(1L, new BigDecimal(200), LocalDate.of(2023, 5, 12), 5, LocalDate.of(2023, 5, 12),LocalDate.of(2023, 5, 17),  15L);
        //When
        Order order = orderMapper.mapToOrder(orderDto);
        //Then
        assertEquals(order.getId(), orderDto.getId());
        assertEquals(order.getCost(), orderDto.getCost());
        assertEquals(order.getCreated(), orderDto.getCreated());
        assertEquals(order.getDays(), orderDto.getDays());
        assertEquals(order.getDateFrom(), orderDto.getDateFrom());
        assertEquals(order.getDateTo(), orderDto.getDateTo());
    }

    @Test
    void mapToOrderDtoList() {
        //Given
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1L, new BigDecimal(200), LocalDate.of(2023, 5, 12), 5, LocalDate.of(2023, 5, 12),LocalDate.of(2023, 5, 17), new User()));
        orders.add(new Order(1L, new BigDecimal(200), LocalDate.of(2023, 5, 12), 5, LocalDate.of(2023, 5, 12),LocalDate.of(2002, 2, 27), new User()));
        orders.add(new Order(1L, new BigDecimal(200), LocalDate.of(2023, 5, 12), 5, LocalDate.of(2023, 5, 12),LocalDate.of(2000, 3, 7), new User()));
        //When
        List<OrderDto> orderDtos = orderMapper.mapToOrderDtoList(orders);
        //Then
        assertEquals(orderDtos.size(), 3);
    }
}