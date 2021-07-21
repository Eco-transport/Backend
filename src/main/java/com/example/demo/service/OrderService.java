package com.example.demo.service;

import com.example.demo.controller.StationController;
import com.example.demo.model.*;
import com.example.demo.pojo.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;
import java.util.*;
import org.springframework.beans.factory.annotation.*;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;    

    @Autowired
    StationController stationController;

    
    Station tmpStation = new Station() ;

    
    //Find all registers inside ORDER table
    public ArrayList<Order> getAllOrders(){
        return (ArrayList<Order>) orderRepository.findAll();
    }

    //Update a row with new data
    // OR enter new register
    public Order saveOrder( Order order ){
        return orderRepository.save( order );
    }

    //Find an order by orderID
    public Order findOrderById( Integer id ){
        return orderRepository.findById( id ).orElse( null );
    }    

    //Find an order by userID
    public String matchingBetweenUserAndOrder( Integer id ){
        ArrayList<Order> tmp = (ArrayList<Order>)orderRepository.findAllByUserId(id);
        ArrayList<Order> result = new ArrayList<>();
        for(Order pedido : tmp){
            int station = pedido.getStationID();
            tmpStation = this.stationController.findStationById(station);
        }

        return tmpStation.getStationName();
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
