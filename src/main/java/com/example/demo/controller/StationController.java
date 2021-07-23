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
@RequestMapping("/station")
public class StationController{
    
    @Autowired
    StationService stationService;

    
    @GetMapping()
    public ArrayList<Station> getStations(){
        return this.stationService.getStations();
    }
    
    @PostMapping("/save")
    public Station saveStation(@RequestBody Station station){
        return this.stationService.saveStation(station);
    }
    
    @GetMapping( path = "/{id}")
    public Station findStationById(@PathVariable("id") Integer id) {
        return this.stationService.findById(id);
    }

    @PostMapping( path = "/addBicycle/{id}")
    public Station addBicycleToStation(@PathVariable("id") Integer id) {
        Station nuevo = stationService.findById(id);
        int available = nuevo.getAvailable() + 1;
        int inventory = nuevo.getInventory() + 1;
        nuevo.setAvailable(available);
        nuevo.setInventory(inventory);
        this.stationService.saveStation(nuevo);
        return this.stationService.findById(id);
    }


    @DeleteMapping()
    public String deleteAllStations(){
        boolean ok = this.stationService.deleteAllStations();
        if (ok){
            return "Se eliminaron todos las ESTACIONES";
        }else{
            return "No se eliminaron todas las ESTACIONES";
        }
    }

    
    @DeleteMapping( path = "/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        boolean ok = this.stationService.deleteStation(id);
        if (ok){
            return "Se eliminó la ESTACION con id " + id;
        }else{
            return "No pudo eliminar la ESTACION con id" + id;
        }
    }



}