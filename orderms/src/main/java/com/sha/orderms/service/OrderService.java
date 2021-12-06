package com.sha.orderms.service;

import com.sha.orderms.entity.Order;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface OrderService {
    public Order save(Order order);
    public Order update(long id, Order order);
    public List<Order> findAll();
    public Order findById(long id);
    public void deleteById(long id);
    public void deleteAll();
}
