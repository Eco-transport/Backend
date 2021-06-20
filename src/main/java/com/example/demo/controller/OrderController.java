package com.example.demo.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.model.*;
import com.example.demo.pojo.*;
import com.example.demo.service.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping()
    public ArrayList<OrderModel> getOrders(){
        return this.orderService.getAllOrders();
    }

    @PostMapping("/save")
    public OrderModel saveOrder(@RequestBody OrderModel order){
        return this.orderService.saveOrder(order);
    }

    @GetMapping( path = "/{orderId}")
    public OrderModel findOrderById(@PathVariable("orderId") Integer id) {
        return this.orderService.findOrderById(id);
    }

    @GetMapping( path = "/test/{orderUserId}")
    public OrderModel findOrderByUserId(@PathVariable("order_user_id") Integer orderUserId) {
        return this.orderService.findOrderByUserId(orderUserId);
    }

    @DeleteMapping()
    public String deleteAllOrders(){
        boolean ok = this.orderService.deleteAllOrders();
        if (ok){
            return "Se eliminaron todos las ORDENES";
        }else{
            return "ERROR BORRAR TODAS ORDENES";
        }
    }
   
    @DeleteMapping( path = "/{order_id}")
    public String deleteById(@PathVariable("order_id") Integer id){
        boolean ok = this.orderService.deleteOrderById(id);
        if (ok){
            return "Se eliminó la ORDEN con id " + id;
        }else{
            return "ERROR eliminar la ORDEN con id" + id;
        }
    }

}
