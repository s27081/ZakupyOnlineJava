package com.example.ZakupyOnline;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderStorage {
    static List<Order> orderStorageList = new ArrayList<>();

    public static List<Order> getOrderStorageList() {
        return orderStorageList;
    }

    public static void setOrderStorageList(List<Order> orderStorageList) {
        OrderStorage.orderStorageList = orderStorageList;
    }

    void addOrder(Order order){
        orderStorageList.add(order);
    }
}
