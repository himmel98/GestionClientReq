package com.gestionClient.controller;

import com.gestionClient.model.Orders;
import com.gestionClient.service.OrdersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    private final OrdersService service;

    public OrdersController(OrdersService service) {
        this.service = service;
    }

    @PostMapping
    public Orders addOrder(@RequestBody Orders o) { return service.addOrder(o); }

    @GetMapping
    public List<Orders> getAllOrders() { return service.getAllOrders(); }

    @GetMapping("/{id}")
    public Optional<Orders> getOrder(@PathVariable Long id) { return service.getOrder(id); }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) { service.deleteOrder(id); }
}

