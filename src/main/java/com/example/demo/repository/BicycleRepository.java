package com.example.demo.repository;

import java.util.Optional;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BicycleRepository extends JpaRepository<BicycleModel, Integer>{

   
    
}
