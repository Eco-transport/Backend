package com.example.demo.repository;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface BicycleRepository extends JpaRepository<Bicycle, Integer>{

    ArrayList<Bicycle> findAllByStationId(Integer id);

    //value = "SELECT * FROM station WHERE station_id = ?1 AND bicycle_status LIKE %?2%",
    /* @Query(
        value = "SELECT * FROM station WHERE station_id = ?1",
        nativeQuery = true
    )
    ArrayList<Bicycle> getAvailableBikes(Integer id, String available); */
}

