package com.example.demo.repository;

import java.util.*;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.*;

import org.springframework.stereotype.Repository;

@Repository
public interface BicycleRepository extends JpaRepository<Bicycle, Integer>{

    

    //ArrayList<Bicycle> findAllByStation(Integer id);
    
    Boolean existsByStationId(Integer id);

    /* @Query(value = "SELECT b FROM bicycle b WHERE b.stationId = ?1")
    ArrayList<Bicycle> listingStation(Integer id); */

    @Query(
        value = "SELECT * FROM bicycle WHERE stationId = ?1",
        nativeQuery = true
    )
    ArrayList<Bicycle> listingStationNative(Integer id);
    
}
