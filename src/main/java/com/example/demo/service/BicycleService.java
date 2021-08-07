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

    //linked with controller -> matchingBikesWithStations()
    public ArrayList<Bicycle> getStations(Integer id){
        return (ArrayList<Bicycle>) bicycleRepository.findAllByStationId(id);
    }

    public Bicycle saveBicycle( Bicycle bicycle ){
        return bicycleRepository.save( bicycle );
    }

    public Bicycle findById( Integer id ){
        return bicycleRepository.findById( id ).orElse( null );
    }
    
    public Bicycle findBySerial(String serial){
        return bicycleRepository.findByBicycleSerialEquals(serial);
    }

    public boolean deleteStation(Integer id) {
        try{
            bicycleRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
