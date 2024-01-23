package com.example.ZakupyOnline;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class OrderShoppingCart {

    private List<Product> orderList;
    private List<Integer> amount;

    public OrderShoppingCart() {
        this.orderList = new ArrayList<>();;
        this.amount = new ArrayList<>();;
    }

    public List<Product> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Product> orderList) {
        this.orderList = orderList;
    }

    public List<Integer> getAmount() {
        return amount;
    }

    public void setAmount(List<Integer> amount) {
        this.amount = amount;
    }
    public void addProduct(Product product, int quantity) {
        orderList.add(product);
        amount.add(quantity);
    }
}
