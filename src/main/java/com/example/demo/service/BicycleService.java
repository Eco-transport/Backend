package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.pojo.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;
import java.util.*;
import org.springframework.beans.factory.annotation.*;

@Service
public class BicycleService {
    @Autowired
    BicycleRepository bicycleRepository;
    
    
    /* public ArrayList<Bicycle> findStation1( Integer id ){
        return (ArrayList<Bicycle>)bicycleRepository.listingStation(id);
    } */
    
    public ArrayList<Bicycle> findStation2( Integer id ){
        return (ArrayList<Bicycle>)bicycleRepository.listingStationNative(id);
    }

    
    
    public Boolean test( Integer id ){
        return bicycleRepository.existsByStationId(id);
    }
    /*
    public ArrayList<Bicycle> getAllBicycles(){
        return (ArrayList<Bicycle>) bicycleRepository.findAll();
    }
    //GUARDAR
    public Bicycle saveBicycle( Bicycle Bicycle ){
        return bicycleRepository.save( Bicycle );
    }
    
    
        

       

    public boolean deleteBicycleById(Integer id) {
        try{
            bicycleRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public boolean deleteAllBicycles(){
        try {
            bicycleRepository.deleteAll();
            return true;
        } catch (Exception e) {
            return  false;
        }
    }

    */
}
