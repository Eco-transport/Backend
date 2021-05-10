package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.pojo.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleService{

    private final RoleRepository roleRepository;

    public RoleService( RoleRepository roleRepository ){
        this.roleRepository = roleRepository;
    }


    public Role findById( Integer id ){
        return roleRepository.findById( id ).orElse( null );
    }

    public List<Role> getAll( ){
        return roleRepository.findAll( );
    }

}
