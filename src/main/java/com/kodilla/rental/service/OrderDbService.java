package com.kodilla.rental.service;

import com.kodilla.rental.domain.Order;
import com.kodilla.rental.exception.OrderNotFoundException;
import com.kodilla.rental.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDbService {
    private final OrderRepository repository;

    public List<Order> getAllOrders(){return repository.findAll();}

    public Order saveOrder(Order order){
        return repository.save(order);
    }

    public Order getOrder(Long orderId) throws OrderNotFoundException{
        return repository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));
    }

    public void deleteOrder(Long orderId) throws OrderNotFoundException{
        repository.deleteById(orderId);
    }
}
