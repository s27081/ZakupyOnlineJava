package com.example.ZakupyOnline;

import org.springframework.stereotype.Component;

public class Order {

    private int orderId;
    private int clientOrderId;
    private OrderShoppingCart orderShoppingCart;
    private Status orderStatus;
    private String address;

    public Order(int orderId, int clientOrderId, OrderShoppingCart orderShoppingCart,String address) {
        this.orderId = orderId;
        this.clientOrderId = clientOrderId;
        this.orderShoppingCart = orderShoppingCart;
        this.address = address;
        this.orderStatus=Status.NOWE;
    }

    public int getOrderId() {
        return orderId;
    }

    public OrderShoppingCart getOrderShoppingCart() {
        return orderShoppingCart;
    }

    public void setOrderShoppingCart(OrderShoppingCart orderShoppingCart) {
        this.orderShoppingCart = orderShoppingCart;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getClientOrderId() {
        return clientOrderId;
    }

    public void setClientOrderId(int orderId) {
        this.clientOrderId = orderId;
    }


    public Status getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Status orderStatus) {
        this.orderStatus = orderStatus;
    }


}
