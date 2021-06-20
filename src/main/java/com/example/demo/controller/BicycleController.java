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
public class BicycleController {
    @Autowired
    BicycleService bicycleService;

    
    @GetMapping()
    public ArrayList<BicycleModel> getBicycles(){
        return this.bicycleService.getBicycles();
    }
    
    @PostMapping("/save")
    public BicycleModel saveBicycle(@RequestBody BicycleModel bicycle){
        return this.bicycleService.saveBicycle(bicycle);
    }
    

    
    @GetMapping( path = "/{bicycle_id}")
    public BicycleModel findBicycleById(@PathVariable("bicycle_id") Integer id) {
        return this.bicycleService.findById(id);
    }

    /*
    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }
    */


    @DeleteMapping()
    public String deleteAllBicycles(){
        boolean ok = this.bicycleService.deleteAllBicycles();
        if (ok){
            return "Se eliminaron todos las ESTACIONES";
        }else{
            return "No se eliminaron todas las ESTACIONES";
        }
    }

    
    @DeleteMapping( path = "/{bicycle_id}")
    public String deleteById(@PathVariable("bicycle_id") Integer id){
        boolean ok = this.bicycleService.deleteBicycle(id);
        if (ok){
            return "Se eliminó la ESTACION con id " + id;
        }else{
            return "No pudo eliminar la ESTACION con id" + id;
        }
    }

}