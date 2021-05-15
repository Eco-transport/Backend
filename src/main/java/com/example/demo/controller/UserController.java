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

import java.util.Collections;
import org.springframework.beans.factory.annotation.*;


@RestController
public class UserController{
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    PasswordEncoder passwordEncoder;

    
    public UserController( UserService userService, RoleService roleService, PasswordEncoder passwordEncoder ){
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

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

}