package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.pojo.*;
import com.example.demo.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.*;
import org.springframework.beans.factory.annotation.*;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    
    public ArrayList<Order> getAllOrders(){
        return (ArrayList<Order>) orderRepository.findAll();
    }
    //GUARDAR
    public Order saveOrder( Order order ){
        return orderRepository.save( order );
    }
    //ENCONTRA POR ID
    public Order findOrderById( Integer id ){
        return orderRepository.findById( id ).orElse( null );
    }    

    public Order findOrderByUserId( Integer userID ){
        return orderRepository.findByUserId( userID );
    }   

    public boolean deleteOrderById(Integer id) {
        try{
            orderRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public boolean deleteAllOrders(){
        try {
            orderRepository.deleteAll();
            return true;
        } catch (Exception e) {
            return  false;
        }
    }
}
