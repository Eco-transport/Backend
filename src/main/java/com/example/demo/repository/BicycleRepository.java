package com.example.demo.repository;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface BicycleRepository extends JpaRepository<Bicycle, Integer>{

    ArrayList<Bicycle> findAllByStationId(Integer id);
    Bicycle findByBicycleSerialEquals(String serial);

}

