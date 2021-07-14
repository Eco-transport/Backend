package com.example.demo.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.*;


import com.example.demo.model.*;
import com.example.demo.pojo.*;
import com.example.demo.service.*;

@RestController
@RequestMapping("/bicycle")
public class BicycleController {
    @Autowired
    BicycleService bicycleService;

    

    /* @GetMapping( path = "/find1/{stationId}")
    public ArrayList<Bicycle> station1(@PathVariable("stationId") Integer id) {
        return this.bicycleService.findStation1(id);
    } */

    @GetMapping( path = "/find2/{stationId}")
    public ArrayList<Bicycle> station2(@PathVariable("stationId") Integer id) {
        return this.bicycleService.findStation2(id); 
    }
    
    @GetMapping( path = "/test/{stationId}")
    public Boolean testing(@PathVariable("stationId") Integer stationID) {
        return this.bicycleService.test(stationID);
    }
}