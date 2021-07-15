package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "order", schema = "public")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;  

    @Id
    @SequenceGenerator( name = "ORDER_ORDERID_GENERATOR", sequenceName = "public.order_order_id_seq", allocationSize = 1 )
    @GeneratedValue( generator = "ORDER_ORDERID_GENERATOR", strategy = GenerationType.SEQUENCE )
    @Column(name = "order_id")
    private Integer id;

    //@Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "order_date", nullable = false)
    private String orderDate;

	@Column(name = "order_status", nullable = false)
    private String orderStatus;

    @Column(name = "order_hours", nullable = false)
    private Integer hours;

    @Column(name = "order_price", nullable = false)
    private Integer price;


    @Column(name = "payment_id", nullable = false)
    private Integer paymentID;

    @Column(name = "station_id", nullable = false)
    private Integer stationID;

    @Column(name = "user_id", nullable = false)
    private Integer userID;


    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "payment_id", insertable = false, updatable = false )
    private Payment payment;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "station_id", insertable = false, updatable = false )
    private Station stationOrder;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "user_id", insertable = false, updatable = false )
    private User user;

    


    /**
     * Constructor
     */

    public Order() {
    }

    /**
     * Getters and setters
     */


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getHours() {
        return this.hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPaymentID() {
        return this.paymentID;
    }

    public void setPaymentID(Integer paymentID) {
        this.paymentID = paymentID;
    }

    public Integer getStationID() {
        return this.stationID;
    }

    public void setStationID(Integer stationID) {
        this.stationID = stationID;
    }

    public Integer getUserID() {
        return this.userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }




    /*Getters and Setters of the relations */
    public Payment getPayment() {
        return this.payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Station getStationOrder() {
        return this.stationOrder;
    }

    public void setStationOrder(Station stationOrder) {
        this.stationOrder = stationOrder;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    

 

    /**
     * Methods
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id.equals(order.id) && orderDate.equals(order.orderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderDate);
    }
}