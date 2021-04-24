package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.UsuarioModel;
import com.example.demo.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    
    

    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public UsuarioModel obtenerUsuarioByEmail(String email){
        return usuarioRepository.findByEmail(email);
    }
    /*
    public ArrayList<UsuarioModel>  obtenerPorPrioridad(Integer prioridad) {
        return usuarioRepository.findByPrioridad(prioridad);
    }*/

    public boolean eliminarTodosUsuario(){
        try {
            usuarioRepository.deleteAll();
            return true;
        } catch (Exception e) {
            return  false;
        }
    }

    public boolean eliminarUsuario(Long id) {
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }


    
}