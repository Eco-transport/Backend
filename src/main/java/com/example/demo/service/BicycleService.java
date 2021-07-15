package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.pojo.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;
import java.util.*;

import org.springframework.beans.factory.annotation.*;



@Service
public class BicycleService{

    @Autowired
    BicycleRepository bicycleRepository;

    public ArrayList<Bicycle> getBicycles(){
        return (ArrayList<Bicycle>) bicycleRepository.findAll();
    }

    public ArrayList<Bicycle> getStations(Integer id){
        return (ArrayList<Bicycle>) bicycleRepository.findAllByStationId(id);
    }

    
}
