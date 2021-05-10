package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.PrestamoModel;
import com.example.demo.services.PrestamoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/API/prestamo")
public class PrestamoController {
    @Autowired
    PrestamoService prestamoService;

    @CrossOrigin(origins = "http://localhost:7000")
    @GetMapping()
    public ArrayList<PrestamoModel> obtenerPrestamos(){
        return prestamoService.obtenerPrestamo();
    }

    @CrossOrigin(origins = "http://localhost:7000")
    @PostMapping("/guardar")
    public PrestamoModel guardarPrestamo(@RequestBody PrestamoModel prestamo){
        return this.prestamoService.guardarPrestamo(prestamo);
    }

    @CrossOrigin(origins = "http://localhost:7000")
    @GetMapping( path = "/{id}")
    public Optional<PrestamoModel> obtenerPrestamoPorId(@PathVariable("id") Long id) {
        return this.prestamoService.obtenerPorId(id);
    }

    /*
    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }
    */


    @DeleteMapping()
    public String eliminarTodasPrestamo(){
        boolean ok = this.prestamoService.eliminarTodasPrestamo();
        if (ok){
            return "Se eliminaron todos las Prestamo";
        }else{
            return "No se eliminaron todas las Prestamo";
        }
    }

    @CrossOrigin(origins = "http://localhost:7000")
    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.prestamoService.eliminarPrestamo(id);
        if (ok){
            return "Se eliminó la Prestamo con id " + id;
        }else{
            return "No pudo eliminar la Prestamo con id" + id;
        }
    }

}