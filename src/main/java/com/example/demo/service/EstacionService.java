package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.pojo.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;


@Service
public class EstacionService{

    private final EstacionRepository EstacionRepository;

    public EstacionService( EstacionRepository EstacionRepository ){
        this.EstacionRepository = EstacionRepository;
    }

    public Estacion findById( Integer id ){
        return EstacionRepository.findById( id ).orElse( null );
    }

    public void save( Estacion Estacion ){
        EstacionRepository.save( Estacion );
    }

}
