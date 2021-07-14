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
    public ArrayList<Station> getStations(){
        return (ArrayList<Station>) stationRepository.findAll();
    }
    //GUARDAR
    public Station saveStation( Station station ){
        return stationRepository.save( station );
    }
    //ENCONTRA POR ID
    public Station findById( Integer id ){
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

    //ELIMINAR 
    public boolean deleteAllStations(){
        try {
            stationRepository.deleteAll();
            return true;
        } catch (Exception e) {
            return  false;
        }
    }
    


}
