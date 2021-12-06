package com.sha.orderms.controller;

import com.sha.orderms.entity.Order;
import com.sha.orderms.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order>  save(@RequestBody Order order){
        return new ResponseEntity<>(orderService.save(order), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order>  update(@PathVariable long id, @RequestBody Order order){
        return new ResponseEntity<>(orderService.save(order), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Order>>  all(){
        return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order>  findById(@PathVariable long id){
        return new ResponseEntity<>(orderService.findById(id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>  deleteById(@PathVariable long id){
        orderService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void>  deleteAll(){
        orderService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
