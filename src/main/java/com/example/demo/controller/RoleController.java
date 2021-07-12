package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.pojo.*;
import com.example.demo.service.*;
import org.springframework.security.core.context.SecurityContextHolder;
/* import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController; */
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;//autowired


import java.util.*;


@RestController
public class RoleController{

    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    
    /* public RoleController( RoleService roleService, UserService userService ){
        this.roleService = roleService;
        this.userService = userService;
    } */

    @GetMapping( "/mi-rol-id" )
    public Integer getUserRoles( ){
        String username = SecurityContextHolder.getContext( ).getAuthentication( ).getName( );
        List<RolePOJO> roles = new ArrayList<>( );
        for( Role role : userService.findByUsername( username ).getRoles( ) ){
            roles.add( new RolePOJO( role ) );
        }
        return roles.get(0).getId();
    }

    @GetMapping( value = { "/roles" } )
    public List<Role> getAllRoles( ){
        return roleService.getAll( );
    }
}
