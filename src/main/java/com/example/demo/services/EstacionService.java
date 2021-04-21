package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.EstacionModel;
import com.example.demo.repositories.EstacionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstacionService {
    @Autowired
    EstacionRepository estacionRepository;
    
    public ArrayList<EstacionModel> obtenerEstaciones(){
        return (ArrayList<EstacionModel>) estacionRepository.findAll();
    }

    public EstacionModel guardarEstacion(EstacionModel estacion){
        return estacionRepository.save(estacion);
    }

    public Optional<EstacionModel> obtenerPorId(Long id){
        return estacionRepository.findById(id);
    }


    public boolean eliminarTodasEstacion(){
        try {
            estacionRepository.deleteAll();
            return true;
        } catch (Exception e) {
            return  false;
        }
    }


    public boolean eliminarEstacion(Long id) {
        try{
            estacionRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }


    
}