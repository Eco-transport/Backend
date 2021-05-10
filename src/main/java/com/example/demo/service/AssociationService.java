package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.pojo.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AssociationService{

    private AssociationRepository associationRepository;

    public AssociationService( AssociationRepository associationRepository ){
        this.associationRepository = associationRepository;
    }

    public void save( Association association ){
        associationRepository.save( association );
    }

    public void associate( User user, Role role, Estacion estacion ){
        Association association = new Association( user, role, estacion );
        save( association );
    }

    public List<Association> getAssociationsByUser( User user ){
        return associationRepository.getAssociationsByUserAndRoles( user, user.getRoles( ) );
    }
}