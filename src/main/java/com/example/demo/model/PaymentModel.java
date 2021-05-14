package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


/**
 * The persistent class for the Payment database table.
 */

@Entity
@Table(name = "payment", schema = "public")
public class PaymentModel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */

    @Id    
    @SequenceGenerator( name = "PAYMENT_PAYMENTID_GENERATOR", sequenceName = "public.payment_payment_id_seq", allocationSize = 1 )
    @GeneratedValue( generator = "PAYMENT_PAYMENTID_GENERATOR", strategy = GenerationType.SEQUENCE )
    @Column(name = "payment_id")
    private Integer id;

    @Column(name = "payment_type", nullable = false)
    private String type;

    /**
     * Relationships: one-to-many association to Order
     */

    /*@JsonIgnore
    @OneToMany(mappedBy = "payment")
    private List<Order> orders;*/

    /**
     * Constructor
     */

    public Payment() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * Methods
     */

    /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id) && Objects.equals(type, payment.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    } */
}