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
    
    public ArrayList<OrderModel> getAllOrders(){
        return (ArrayList<OrderModel>) orderRepository.findAll();
    }
    //GUARDAR
    public OrderModel saveOrder( OrderModel order ){
        return orderRepository.save( order );
    }
    //ENCONTRA POR ID
    public OrderModel findOrderById( Integer id ){
        return orderRepository.findById( id ).orElse( null );
    }    

    public OrderModel findOrderByUserId( Integer Userid ){
        return orderRepository.findByOrderUserId( Userid );
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
