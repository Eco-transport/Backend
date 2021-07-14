package com.example.demo.repository;

import java.util.Optional;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

    Order findByUserId(Integer userID);
    
}