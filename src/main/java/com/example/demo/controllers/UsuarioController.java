package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.*;
import com.example.demo.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/API/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @CrossOrigin(origins = "http://localhost:7000")
    @PostMapping("/checkLogin")
    public Boolean checkLogin(@RequestBody LoginModel login){
        if(login == null)
            return false;
        if(login.getEmail().equals(this.obtenerUsuarioByEmail(login.getEmail()).getEmail()) 
            && login.getContrasena().equals(this.obtenerUsuarioByEmail(login.getEmail()).getContrasena()))
            return true;        
        return false;
    }
    @CrossOrigin(origins = "http://localhost:7000")
    @PostMapping("/email")
    public UsuarioModel afterLogin(@RequestBody LoginModel login){
        return this.usuarioService.obtenerUsuarioByEmail(login.getEmail());
    }

    public void afterCheckLogin(){

    }

    @CrossOrigin(origins = "http://localhost:7000")
    @PostMapping("/securityQuestion")
    public String securityQuestion(@RequestBody SecMode usuario){
        String pregunta = "";
        if(usuario.getEmail().equals(this.usuarioService.obtenerUsuarioByEmail(usuario.getEmail()).getEmail())){
            pregunta = this.usuarioService.obtenerUsuarioByEmail(usuario.getEmail()).getPregunta();
        }
        return pregunta;
    }

    @CrossOrigin(origins = "http://localhost:7000")
    @PostMapping("/securityAnswer")
    public Boolean securityAnswer(@RequestBody ForgotPasswordModel forgot){
        if(forgot.getEmail().equals(this.obtenerUsuarioByEmail(forgot.getEmail()).getEmail()) 
        && forgot.getRespuesta().equals(this.obtenerUsuarioByEmail(forgot.getEmail()).getRespuesta())){   
            return true;
        }
        return false;   
    }

    @GetMapping("/obtener")
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @CrossOrigin(origins = "http://localhost:7000")
    @PostMapping("/guardar")
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }

    
    @GetMapping( path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.usuarioService.obtenerPorId(id);
    }

    @CrossOrigin(origins = "http://localhost:7000")
    @GetMapping("/query")
    public UsuarioModel obtenerUsuarioByEmail(String email){
        return this.usuarioService.obtenerUsuarioByEmail(email);
    }
    
    

    /* este query se usa con el requestParam para usarlo desde el URL
     Es decir http://localhost:8080/API/usuario/query?email=juanito@gmail.com
    @GetMapping("/query")
    public UsuarioModel obtenerUsuarioByEmail(@RequestParam("email") String email){
        return this.usuarioService.obtenerUsuarioByEmail(email);
    }*/

    /*
    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }
    */

    @DeleteMapping()
    public String eliminarTodosUsuario(){
        boolean ok = this.usuarioService.eliminarTodosUsuario();
        if (ok){
            return "Se eliminaron todos los USUARIOS";
        }else{
            return "No se eliminaron todos los USUARIOS";
        }
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No pudo eliminar el usuario con id" + id;
        }
    }

}