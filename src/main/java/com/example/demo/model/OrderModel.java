package com.example.demo.model;
import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table( name = "order", schema = "public" )
public class OrderModel implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "order_id" )
    private Integer orderId;
    
    @Column( name = "order_date" )
    private String orderDate;
    
    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "order_comments")
    private String orderComments;

    @Column(name = "order_station_id")
    private Integer orderStationId;

    @Column(name = "order_user_id")
    private Integer orderUserId;

    @Column(name = "order_bicycle_id")
    private Integer orderBicycleId;
    
    @Column(name = "order_time")
    private Integer orderTime;
    
    @Column(name = "order_total_price")
    private Integer orderTotalPrice;
     
    public OrderModel( ){
        // Default constructor is required
    }
   


    
    public Integer getOrderId() {
        return orderId;
    }

    
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    
    public String getOrderComments() {
        return orderComments;
    }

    
    public void setOrderComments(String orderComments) {
        this.orderComments = orderComments;
    }

    
    public Integer getOrderStationId() {
        return orderStationId;
    }

    
    public void setOrderStationId(Integer orderStationId) {
        this.orderStationId = orderStationId;
    }

    
    public Integer getOrderUserId() {
        return orderUserId;
    }

    
    public void setOrderUserId(Integer orderUserId) {
        this.orderUserId = orderUserId;
    }

    
    public Integer getOrderBicycleId() {
        return orderBicycleId;
    }

    
    public void setOrderTime(Integer orderTime) {
        this.orderTime = orderTime;
    }

   public Integer getOrderTime() {
        return orderTime;
    }
     

     public void setOrderTotalPrice(Integer orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

   public Integer getOrderTotalPrice() {
        return orderTotalPrice;
    }
}
