package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table( name = "station", schema = "public" )
public class Station implements Serializable{

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


	@JsonIgnore
	@OneToMany(mappedBy="station", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Bicycle> bicycles;

	@JsonIgnore
	@OneToMany(mappedBy="station", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Order> orders;

	





	/**
     * Constructors
     */

    public Station( ){
        // Default constructor is required
    }

    /**
     * Getters and Setters
     */

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public List<Bicycle> getBicycles() {
		return this.bicycles;
	}

	public void setBicycles(List<Bicycle> bicycles) {
		this.bicycles = bicycles;
	}





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

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Station )) return false;
        return id != null && id.equals(((Station) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}