package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.pojo.*;
import com.example.demo.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import org.springframework.beans.factory.annotation.*;


@RestController
public class UserController{
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    PasswordEncoder passwordEncoder;

    // CONSTRUCTOR
    public UserController( UserService userService, RoleService roleService, PasswordEncoder passwordEncoder ){
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }


    //SPRINT 3 COMIENZA

    @GetMapping( "/user/all" )
    public ArrayList<User> gettingAll(){
        return userService.findAllUsers();
    }


    @GetMapping( "/user/getUser" )
    public User getUser( ){        
        String username = SecurityContextHolder.getContext( )
                            .getAuthentication( )
                            .getName(); //getName return the username logged. 
                                        //This must be unique but rigth now is configurated July-15-2021

        User usuario = userService.findByUsername(username);
        return new User(usuario.getId(), usuario.getNames(), usuario.getUsername(), usuario.getIdentityNumber());
    }

    @GetMapping( "/user/getNames" )
    public String getNames( ){
        String username = SecurityContextHolder.getContext( ).getAuthentication( ).getName(); 
        User nuevo = userService.findByUsername(username);
        return nuevo.getNames();        
    }

    //SPRINT 3 TERMINA






    @PostMapping( value = { "/registro/nuevo-usuario" } )
    public ResponseEntity<Void> registerNewUser( @RequestBody User userPOJO ){
        Role role = roleService.findById( 1 );
        User existingUser = userService.findByUsername( userPOJO.getUsername( ) );
        if( role == null || existingUser != null || !userService.isRightUser( userPOJO ) ){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
        User newUser = new User( );
        newUser.setNames( userPOJO.getNames( ).toUpperCase( ) );
        newUser.setSurnames( userPOJO.getSurnames( ).toUpperCase( ) );
        newUser.setUsername( userPOJO.getUsername( ).toLowerCase( ) );
        newUser.setPassword( passwordEncoder.encode( userPOJO.getPassword( ) ) );
        newUser.setIdentityNumber( userPOJO.getIdentityNumber( ) );
        newUser.setEmail( userPOJO.getEmail( ) );
        newUser.setUserPhone( userPOJO.getUserPhone( ) );
        newUser.setSecurityQuestion( userPOJO.getSecurityQuestion( ) );
        newUser.setSecurityAnswer( userPOJO.getSecurityAnswer( ) );
        newUser.setUserState( userPOJO.getUserState( ) );
        newUser.setRoles( Collections.singletonList( role ) );
        userService.save( newUser );
        return new ResponseEntity<>( HttpStatus.CREATED );
    }

    @GetMapping( path = "/recuperar-password/get-question/{username}")
    public String recuperarPasswordByUsername(@PathVariable("username") String username) {
        return this.userService.findByUsername(username).getSecurityQuestion();
    }

    @PostMapping( value = { "/recuperar-password/verificar" })
    public Boolean recuperarPasswordVerificar( @RequestBody RecuperarPasswordPOJO passPOJO ) {
        User usuario = new User(); 
        Boolean resp = false;
        usuario = this.userService.findByUsername(passPOJO.getUsername());
        if(usuario.getSecurityAnswer().equals(passPOJO.getAnswer())){
            resp = true;
        }
        return resp;
    }

    @PostMapping( value = { "/recuperar-password/cambiar" })
    public Boolean recuperarPasswordCambiar( @RequestBody LoginUserPOJO userPOJO ) {
        User update_user = new User(); 
        Boolean resp = false;
        update_user = this.userService.findByUsername(userPOJO.getUsername()); 
        update_user.setPassword( passwordEncoder.encode(userPOJO.getPassword()) );
        userService.save(update_user);
        update_user = this.userService.findByUsername(userPOJO.getUsername()); 
        return true;
    }

}