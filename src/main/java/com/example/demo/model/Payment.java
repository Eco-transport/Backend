package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the Payment database table.
 */

@Entity
@Table(name = "payment", schema = "public")
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator( name = "PAYMENT_PAYMENTID_GENERATOR", sequenceName = "public.payment_payment_id_seq", allocationSize = 1 )
    @GeneratedValue( generator = "PAYMENT_PAYMENTID_GENERATOR", strategy = GenerationType.SEQUENCE )
    @Column(name = "payment_id")
    private Integer id;

    @Column(name = "payment_type", nullable = false)
    private String type;

    @JsonIgnore
    @OneToMany(mappedBy = "payment", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Order> orders;

	


    /**
     * Constructor
     */

    public Payment() {
    }

    /**
     * Getters and setters
     */


    public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * Methods
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment )) return false;
        return id != null && id.equals(((Payment) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}