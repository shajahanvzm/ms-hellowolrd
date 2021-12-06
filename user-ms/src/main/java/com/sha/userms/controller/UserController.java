package com.sha.userms.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sha.userms.entity.User;
import com.sha.userms.fc.config.OrdermsFeingClientConfig;
import com.sha.userms.service.UserService;

import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final OrdermsFeingClientConfig ordermsFC;

    public UserController(UserService userService, OrdermsFeingClientConfig ordermsFC) {
        this.userService = userService;
        this.ordermsFC = ordermsFC;
    }


    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable long id, @RequestBody User user){
        return new ResponseEntity<>(userService.update(id,user), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> all(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable long id){
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        userService.deleteById(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll(){
        userService.deleteAll();
        return new ResponseEntity<>( HttpStatus.OK);
    }
    
    @GetMapping("/orders")
    @HystrixCommand(fallbackMethod = "getFromFallback")
    public ResponseEntity<Object> allOrders(){
        Object orders = ordermsFC.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    public ResponseEntity<Object> getFromFallback(){
    	System.out.println("Fall back");
         return new ResponseEntity<>(Arrays.asList("One","two","Three"), HttpStatus.OK);
    }
}
