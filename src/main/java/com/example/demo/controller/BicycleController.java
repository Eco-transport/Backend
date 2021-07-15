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
    
    @GetMapping( path = "/{stationId}")
    public ArrayList<Bicycle> getStation(@PathVariable("stationId") Integer id ){
        return this.bicycleService.getStations(id);
    }


}