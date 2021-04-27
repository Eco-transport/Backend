package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.EstacionModel;
import com.example.demo.services.EstacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/API/estacion")
public class EstacionController {
    @Autowired
    EstacionService estacionService;

    @CrossOrigin(origins = "http://localhost:7000")
    @GetMapping()
    public ArrayList<EstacionModel> obtenerEstaciones(){
        return estacionService.obtenerEstaciones();
    }

    @CrossOrigin(origins = "http://localhost:7000")
    @PostMapping("/guardar")
    public EstacionModel guardarEstacion(@RequestBody EstacionModel estacion){
        return this.estacionService.guardarEstacion(estacion);
    }

    @CrossOrigin(origins = "http://localhost:7000")
    @GetMapping( path = "/{id}")
    public Optional<EstacionModel> obtenerEstacionPorId(@PathVariable("id") Long id) {
        return this.estacionService.obtenerPorId(id);
    }

    /*
    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }
    */


    @DeleteMapping()
    public String eliminarTodasEstacion(){
        boolean ok = this.estacionService.eliminarTodasEstacion();
        if (ok){
            return "Se eliminaron todos las ESTACIONES";
        }else{
            return "No se eliminaron todas las ESTACIONES";
        }
    }

    @CrossOrigin(origins = "http://localhost:7000")
    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.estacionService.eliminarEstacion(id);
        if (ok){
            return "Se eliminó la ESTACION con id " + id;
        }else{
            return "No pudo eliminar la ESTACION con id" + id;
        }
    }

}