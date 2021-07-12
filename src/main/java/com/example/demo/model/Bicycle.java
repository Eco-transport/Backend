package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * The persistent class for the Bicycle database table.
 */

@Entity
@Table(name = "bicycle")
public class Bicycle implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "bicycle_id")
    private Integer id;

    @Column(name = "bicycle_name", nullable = false)
    private String bicycleName;

    @Column(name = "bicycle_vendor", nullable = false)
    private String vendor;

    @Column(name = "bicycle_stock", nullable = false)
    private Integer stock;

    @Column(name = "bicycle_buyprice", nullable = false)
    private Integer buyPrice;

    /**
     * Relationships: bi-directional many-to-many association to Station
     */

    @ManyToMany(mappedBy = "bicycles")
    @JsonIgnore
    private List<StationModel> stations;

    /**
     * Constructor
     */

    public Bicycle() {
    }

    /**
     * Getters and setters
     */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBicycleName() {
        return bicycleName;
    }

    public void setBicycleName(String bicycleName) {
        this.bicycleName = bicycleName;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Integer buyPrice) {
        this.buyPrice = buyPrice;
    }

    /**
     * Methods
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bicycle bicycle = (Bicycle) o;
        return id.equals(bicycle.id) && bicycleName.equals(bicycle.bicycleName) && vendor.equals(bicycle.vendor) && buyPrice.equals(bicycle.buyPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bicycleName, vendor, buyPrice);
    }
}