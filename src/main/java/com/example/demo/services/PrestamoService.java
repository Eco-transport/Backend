package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.PrestamoModel;
import com.example.demo.repositories.PrestamoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrestamoService {
    @Autowired
    PrestamoRepository prestamoRepository;
    
    public ArrayList<PrestamoModel> obtenerPrestamo(){
        return (ArrayList<PrestamoModel>) prestamoRepository.findAll();
    }

    public PrestamoModel guardarPrestamo(PrestamoModel prestamo){
        return prestamoRepository.save(prestamo);
    }

    public Optional<PrestamoModel> obtenerPorId(Long id){
        return prestamoRepository.findById(id);
    }


    public boolean eliminarTodasPrestamo(){
        try {
            prestamoRepository.deleteAll();
            return true;
        } catch (Exception e) {
            return  false;
        }
    }


    public boolean eliminarPrestamo(Long id) {
        try{
            prestamoRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }}