package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the Bicycle database table.
 */

@Entity
@Table(name = "bicycle" , schema = "public" )
public class Bicycle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bicycle_id")
    private Integer id;   
    @Column(name = "bicycle_vendor", nullable = false)
    private String vendor;
    @Column( name = "bicycle_serial", nullable = false )
    private String bicycleSerial;    
    @Column( name = "bicycle_status", nullable = false )
    private String bicycleStatus;
    @Column( name = "station_id", nullable = false )
    private Integer stationId;

	


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)    
    @JoinColumn(name= "station_id", insertable=false, updatable=false)
    private Station station;

	


    /**
     * Constructor
     */

    public Bicycle() {
    }

    public Bicycle(Integer id) {
        this.id = id;
    }

    public Bicycle(Integer id, String vendor, String bicycleSerial, String bicycleStatus, Integer stationId) {
        this.id = id;
        this.vendor = vendor;
        this.bicycleSerial = bicycleSerial;
        this.bicycleStatus = bicycleStatus;
        this.stationId = stationId;        
    }

    

    /**
     * Getters and setters for the relation tables
     */

    public Integer getStationId() {
		return this.stationId;
	}

	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}

    public Station getStation() {
		return this.station;
	}

	public void setStation(Station station) {
		this.station = station;
	}


    /**
     * Getters and setters for atributes
     */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getBicycleSerial() {
        return this.bicycleSerial;
    }

    public void setBicycleSerial(String bicycleSerial) {
        this.bicycleSerial = bicycleSerial;
    }

    public String getBicycleStatus() {
        return this.bicycleStatus;
    }

    public void setBicycleStatus(String bicycleStatus) {
        this.bicycleStatus = bicycleStatus;
    }


    /**
     * Methods
     */

    /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bicycle )) return false;
        return id != null && id.equals(((Bicycle) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    } */
}