package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * The persistent class for the Order database table.
 */

@Entity
@Table(name = "order", schema = "public")
public class OrderModel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */

    @Id
    @SequenceGenerator( name = "ORDER_ORDERID_GENERATOR", 
        sequenceName = "public.order_order_id_seq", allocationSize = 1 )
    @GeneratedValue( generator = "ORDER_ORDERID_GENERATOR", strategy = GenerationType.SEQUENCE )
    @Column(name = "order_id")
    private Integer id;

    @Column(name = "order_date", nullable = false)
    private Timestamp orderDate;

    //HAY QUE REVISAR SI ESTOS ESTADOS SE HACEN EN OTRA TABLA
    @Column(name = "order_status", nullable = false)
    private String orderStatus;

    @Column(name = "order_comments")
    private String orderComments;

    /**
     * Relationships: one-to-many association to Payment
     *                  many-to-one association to StationBicycle
     */

    /*@ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "stationBicyclePK")
    private StationBicycle stationBicycle;*/

    /**
     * Constructor
     */

    public Order() {
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

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderComments() {
        return orderComments;
    }

    public void setOrderComments(String orderComments) {
        this.orderComments = orderComments;
    }

    /**
     * Methods
     */

    /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id.equals(order.id) && orderDate.equals(order.orderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderDate);
    } */
}