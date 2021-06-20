package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;


/**
 * The persistent class for the Estacion database table.
 */
@Entity
@Table( name = "estacion", schema = "public" )
public class StationModel implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */

    @Id
    @SequenceGenerator( name = "ESTACION_ESTACIONID_GENERATOR",
            sequenceName = "public.estacion_station_id_seq", allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "ESTACION_ESTACIONID_GENERATOR" )
    @Column( name = "station_id" )
    private Integer id;    
    
    @Column( name = "station_name" )
    private String stationName;    

    @Column(name = "station_address", nullable = false)
    private String address;

    @Column(name = "station_phone", nullable = false)
    private String phone;

    @Column(name = "station_city", nullable = false)
    private String city;

    @Column(name = "station_inventory", nullable = false)
    private Integer inventory;

    @Column(name = "station_available", nullable = false)
    private Integer available;

    @Column(name = "station_open_time", nullable = false)
    private String openTime;    

    @Column(name = "station_close_time", nullable = false)
    private String closeTime;

	


    

    

    /**
     * Constructors
     */

    public StationModel( ){
        // Default constructor is required
    }

    /**
     * Getters and Setters
     */

    public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStationName() {
		return this.stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public Integer getAvailable() {
		return this.available;
	}

	public void setAvailable(Integer available) {
		this.available = available;
	}

	public Integer getInventory() {
		return this.inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

    public String getOpenTime() {
		return this.openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getCloseTime() {
		return this.closeTime;
	}

	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}

	


    
    /**
     * Methods
     */

    /* @Override
    public boolean equals( Object object ){
        if( !(object instanceof Estacion) ) return false;
        return id.equals( ((Estacion) object).getId( ) );
    }

    @Override
    public int hashCode( ){
        return id;
    } */
}