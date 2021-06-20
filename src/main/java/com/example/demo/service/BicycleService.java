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

    //LISTAR ESTACIONES
    public ArrayList<BicycleModel> getBicycles(){
        return (ArrayList<BicycleModel>) bicycleRepository.findAll();
    }
    //GUARDAR
    public BicycleModel saveBicycle( BicycleModel bicycle ){
        return bicycleRepository.save( bicycle );
    }
    //ENCONTRA POR ID
    public BicycleModel findById( Integer id ){
        return bicycleRepository.findById( id ).orElse( null );
    }

    //ELIMINAR POR ID
    public boolean deleteBicycle(Integer id) {
        try{
            bicycleRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    //ELIMINAR TODO
    public boolean deleteAllBicycles(){
        try {
            bicycleRepository.deleteAll();
            return true;
        } catch (Exception e) {
            return  false;
        }
    }
}