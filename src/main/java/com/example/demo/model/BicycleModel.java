package com.example.demo.model;
import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table( name = "bicycle", schema = "public" )

public class BicycleModel implements Serializable{
    /*
    "bicycle_id"   SERIAL     NOT NULL,
    "bicycle_name" VARCHAR(20) ,
    "bicycle_vendor" VARCHAR(20) ,
    "bicycle_buy_price"   INTEGER,
    "bicycle_state"  VARCHAR(20)
    */ 

  
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "bicycle_id" )
    private Integer bicycleID;
    @Column( name = "bicycle_name" )
    private String bicycleName;
    @Column( name = "bicycle_vendor" )
    private String bicycleVendor;
    @Column( name = "bicycle_buy_price" )
    private Integer bicycleBuyPrice;
    @Column( name = "bicycle_state" )
    private String bicycleState;
    @Column( name = "bicycle_station_id" )
    private Integer bicycleStationId;
    

    

    public Integer getBicycleID() {
        return this.bicycleID;
    }

    public void setBicycleID(Integer bicycleID) {
        this.bicycleID = bicycleID;
    }

    public String getBicycleName() {
        return this.bicycleName;
    }

    public void setBicycleName(String bicycleName) {
        this.bicycleName = bicycleName;
    }

    public String getBicycleVendor() {
        return this.bicycleVendor;
    }

    public void setBicycleVendor(String bicycleVendor) {
        this.bicycleVendor = bicycleVendor;
    }

    public Integer getBicycleBuyPrice() {
        return this.bicycleBuyPrice;
    }

    public void setBicycleBuyPrice(Integer bicycleBuyPrice) {
        this.bicycleBuyPrice = bicycleBuyPrice;
    }

    public String getBicycleState() {
        return this.bicycleState;
    }

    public void setBicycleState(String bicycleState) {
        this.bicycleState = bicycleState;
    }

    public Integer getBicycleStationId() {
        return this.bicycleStationId;
    }

    public void setBicycleStationId(Integer bicycleStationId) {
        this.bicycleStationId = bicycleStationId;
    }

}