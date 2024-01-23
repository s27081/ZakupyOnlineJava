package com.example.ZakupyOnline;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public int orderID = 1;
    private final ProductStorage productStorage;

    private final OrderStorage orderStorage;

    public OrderService(ProductStorage productStorage, OrderStorage orderStorage){
        this.productStorage = productStorage;
        this.orderStorage = orderStorage;
    }

    public void createOrder(int id, OrderShoppingCart orderShoppingCart, String address) {
        if (orderShoppingCart.getOrderList().stream()
                .allMatch(p -> ProductStorage.productList.contains(p))) {
            orderStorage.addOrder(new Order(orderID, id, orderShoppingCart, address));
            orderID++;
        }
    }

    public Order checkOrder(int orderID){
        return OrderStorage.orderStorageList.stream()
                .filter(e -> e.getOrderId() == orderID)
                .findFirst()
                .orElse(null);

    }

    public Order cancelOrder(int orderID) {
        for (Order element : OrderStorage.orderStorageList) {
            if (element.getOrderId() == orderID && element.getOrderStatus() != Status.W_REALIZACJI) {
                element.setOrderStatus(Status.ANULOWANE);
                return element;
            }
        }
        System.out.println("Zamówienie o tym numerze nie istnieje lub jest już w trakcie realizacji");
        return null;
    }

    public Order confirmOrder(int orderID){
        for (Order element : OrderStorage.orderStorageList) {
            if (element.getOrderId() == orderID && element.getOrderStatus() == Status.DOSTARCZONE) {
                return element;
            }
        }
        System.out.println("Zamówienie o tym numerze nie istnieje lub zostało zrealizowane");
        return null;
    }
}
