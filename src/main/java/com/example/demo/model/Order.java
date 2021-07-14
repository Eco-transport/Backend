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
public class Order implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer id;

    @Column(name = "order_date", nullable = false)
    private String orderDate;

    @Column(name = "order_status", nullable = false)
    private String orderStatus;

    @Column(name = "payment_id", nullable = false)
    private Integer paymentID;

    @Column(name = "station_id", nullable = false)
    private Integer stationID;

    @Column(name = "user_id", nullable = false)
    private Integer userID;


    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "payment_id", insertable = false, updatable = false )
    private Payment payment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "station_id", insertable = false, updatable = false )
    private Station station;

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
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
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



    





	public Payment getPayment() {
		return this.payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
    
    public Station getStation() {
		return this.station;
	}

	public void setStation(Station station) {
		this.station = station;
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