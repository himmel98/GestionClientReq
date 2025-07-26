package com.gestionClient.service;

import com.gestionClient.model.Orders;
import com.gestionClient.repos.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {
    private final OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public Orders addOrder(Orders order) { return ordersRepository.save(order); }
    public List<Orders> getAllOrders() { return ordersRepository.findAll(); }
    public Optional<Orders> getOrder(Long id) { return ordersRepository.findById(id); }
    public void deleteOrder(Long id) { ordersRepository.deleteById(id); }
}