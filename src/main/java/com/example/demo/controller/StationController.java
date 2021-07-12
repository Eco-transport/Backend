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
    public ArrayList<StationModel> getStations(){
        return this.stationService.getStations();
    }
    
    @PostMapping("/save")
    public StationModel saveStation(@RequestBody StationModel station){
        return this.stationService.saveStation(station);
    }
    

    
    @GetMapping( path = "/{id}")
    public StationModel findStationById(@PathVariable("id") Integer id) {
        return this.stationService.findById(id);
    }

    /*
    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }
    */


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