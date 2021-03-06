package com.example.demo.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.model.*;
import com.example.demo.pojo.*;
import com.example.demo.service.*;

@RestController
@RequestMapping("/bicycle")
public class BicycleController{
    
    @Autowired
    BicycleService bicycleService;
    
    @GetMapping()
    public ArrayList<Bicycle> getBicycles(){
        return this.bicycleService.getBicycles();
    }
    
    @PostMapping("/save")
    public Bicycle saveBicycle(@RequestBody Bicycle bicycle){
        return this.bicycleService.saveBicycle(bicycle);
    }

    @GetMapping( path = "/id/{id}")
    public Bicycle findStationById(@PathVariable("id") Integer id) {
        return this.bicycleService.findById(id);
    }

    @GetMapping( path="/serial/{bicycleSerial}")
    public Bicycle findBySerial(@PathVariable("bicycleSerial") String serial){
        return this.bicycleService.findBySerial(serial);
    }

    @GetMapping( path = "/findBicycle/{id}")
    public Bicycle findBicycleById(@PathVariable("id") Integer id) {
        return this.bicycleService.findById(id);
    }

    // Retorna la primera bicicleta disponible que pertenezca a la estación
    @GetMapping( path = "/{stationId}")
    public Bicycle matchingBikesWithStations(@PathVariable("stationId") Integer id ){
        ArrayList<Bicycle> stations = this.bicycleService.getStations(id);
        Bicycle bike = new Bicycle();
        for(int i= 0; i<stations.size(); i++){
            Bicycle tmp = stations.get(i);
            if(tmp.getBicycleStatus().equals("Disponible")){
                bike = new Bicycle(tmp.getId(), 
                                    tmp.getVendor(), 
                                    tmp.getBicycleSerial(),
                                    tmp.getBicycleStatus(),
                                    tmp.getStationId()
                                    );
                break;
            } else {
                bike = new Bicycle(-1);//meaning something happened
            }               
        }
        
        return bike;
    }

    @DeleteMapping( path = "/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        boolean ok = this.bicycleService.deleteStation(id);
        if(ok) {
            return "Se eliminó la ESTACION con id " + id;
        } else {
            return "No pudo eliminar la ESTACION con id" + id;
        }
    }
}