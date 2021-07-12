package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the StationBicycle database table.
 */


@Entity
@Table(name = "station_bicycle", schema = "public")
public class StationBicycle implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */

    @EmbeddedId
    private StationBicyclePK stationBicyclePK;

    /*@JsonIgnore
    @OneToMany(mappedBy = "stationBicycle")
    private List<Order> orders;*/

    /**
     * Constructors
     */


    public StationBicycle(){
        stationBicyclePK = new StationBicyclePK();
    }

    /**
     * Getters and setters
     */


    StationModel getEstacion(){
        return stationBicyclePK.getStation();
    }

    void setEstacion(StationModel station){
        stationBicyclePK.setStation(station);
    }

    Bicycle getBicycle(){
        return stationBicyclePK.getBicycle();
    }

    void setBicycle(Bicycle bicycle){
        stationBicyclePK.setBicycle(bicycle);
    }

    /**
     * Private class for primary key
     */


    @Embeddable
    private static class StationBicyclePK implements Serializable{

        private static final long serialVersionUID = 1L;

        /**
         * Attributes
         * Relationships: many-to-one association to Station
         *                  many-to-one association to Bicycle
         *                  one-to-many association to Order
         */


        @ManyToOne
        @JoinColumn(name = "station_id", insertable = false, updatable = false)
        private StationModel station;

        @ManyToOne
        @JoinColumn(name = "bicycle_id", insertable = false, updatable = false)
        private Bicycle bicycle;

        /**
         * Constructor
         */


        public StationBicyclePK() {
        }

        public StationBicyclePK(StationModel station, Bicycle bicycle){
            this.station = station;
            this.bicycle = bicycle;
        }

        /**
         * Getters and setters
         */

        public StationModel getStation() {
            return station;
        }

        public void setStation(StationModel station) {
            this.station = station;
        }

        public Bicycle getBicycle() {
            return bicycle;
        }

        public void setBicycle(Bicycle bicycle) {
            this.bicycle = bicycle;
        }
    }
}
