package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.pojo.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;
import java.util.*;

import org.springframework.beans.factory.annotation.*;



@Service
public class StationService{

    @Autowired
    StationRepository stationRepository;

    //CONSTRUCTOR    
    /* public StationService( StationRepository stationRepository ){
        this.stationRepository = stationRepository;
    } */

    //LISTAR ESTACIONES
    public ArrayList<StationModel> getStations(){
        return (ArrayList<StationModel>) stationRepository.findAll();
    }
    //GUARDAR
    public StationModel saveStation( StationModel station ){
        return stationRepository.save( station );
    }
    //ENCONTRA POR ID
    public StationModel findById( Integer id ){
        return stationRepository.findById( id ).orElse( null );
    }

    //ELIMINAR POR ID
    public boolean deleteStation(Integer id) {
        try{
            stationRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    //ELIMINAR TODO
    public boolean deleteAllStations(){
        try {
            stationRepository.deleteAll();
            return true;
        } catch (Exception e) {
            return  false;
        }
    }
    


}
