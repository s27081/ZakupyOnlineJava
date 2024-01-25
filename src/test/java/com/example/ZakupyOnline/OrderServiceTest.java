package com.example.ZakupyOnline;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class OrderServiceTest {

    private OrderStorage orderStorage;

    private ProductStorage productStorage;

    private OrderShoppingCart orderShoppingCart;

    private OrderService orderService;
    @BeforeEach
    void setup(){
        this.productStorage = new ProductStorage();
        this.orderStorage = new OrderStorage();
        this.orderService = new OrderService(productStorage,orderStorage);
        this.orderShoppingCart = new OrderShoppingCart();
        ProductStorage.productList.clear();
        OrderStorage.orderStorageList.clear();
    }

    private Product product1 = new Product(1,"koszulka",100);
    private Product product2 = new Product(2,"spodnie",150);
    private Product product3 = new Product(3,"bluza",120);
    private Product product4= new Product(4,"kurtka",300);


    @Test
    void orderCreateTest(){
        productStorage.addProduct(product1);
        productStorage.addProduct(product2);
        productStorage.addProduct(product3);

        orderShoppingCart.addProduct(product1, 5);
        orderShoppingCart.addProduct(product3,1);
        orderService.createOrder(12,orderShoppingCart,"xyz");

        assertThat(orderStorage.getOrderStorageList()).isNotNull();
    }
    @Test
    void doesNotCreateOrderTest(){
        productStorage.addProduct(product1);
        productStorage.addProduct(product2);
        productStorage.addProduct(product3);

        orderShoppingCart.addProduct(product1, 5);
        orderShoppingCart.addProduct(product4,1);
        orderService.createOrder(12,orderShoppingCart,"xyz");

        assertThat(orderStorage.getOrderStorageList()).isEmpty();
    }

    @Test
    void checkOrderTest(){
        productStorage.addProduct(product1);
        productStorage.addProduct(product2);
        productStorage.addProduct(product3);

        orderShoppingCart.addProduct(product1, 5);
        orderShoppingCart.addProduct(product3,1);
        orderService.createOrder(12,orderShoppingCart,"xyz");

        assertThat(orderService.checkOrder(1)).isNotNull();
    }

    @Test
    void doesNotCheckOrderTest(){
        productStorage.addProduct(product1);
        productStorage.addProduct(product2);
        productStorage.addProduct(product3);

        orderShoppingCart.addProduct(product1, 5);
        orderShoppingCart.addProduct(product4,1);
        orderService.createOrder(12,orderShoppingCart,"xyz");

        assertThat(orderService.checkOrder(1)).isNull();

    }

    @Test
    void cancelOrderTest(){
        productStorage.addProduct(product1);
        productStorage.addProduct(product2);
        productStorage.addProduct(product3);

        orderShoppingCart.addProduct(product1, 5);
        orderShoppingCart.addProduct(product3,1);
        orderService.createOrder(12,orderShoppingCart,"xyz");
        orderService.cancelOrder(1);
        assertThat(orderStorage.getOrderStorageList().getLast().getOrderStatus()).isEqualTo(Status.ANULOWANE);
    }

    @Test
    void notCancelOrderTest(){
        productStorage.addProduct(product1);
        productStorage.addProduct(product2);
        productStorage.addProduct(product4);

        orderShoppingCart.addProduct(product1, 5);
        orderShoppingCart.addProduct(product3,1);
        orderService.createOrder(12,orderShoppingCart,"xyz");

        assertThat(orderService.cancelOrder(1)).isNull();
    }
    @Test
    void confirmOrderTest(){
        productStorage.addProduct(product1);
        productStorage.addProduct(product2);
        productStorage.addProduct(product3);

        orderShoppingCart.addProduct(product1, 5);
        orderShoppingCart.addProduct(product3,1);
        orderService.createOrder(12,orderShoppingCart,"xyz");
        orderStorage.getOrderStorageList().getLast().setOrderStatus(Status.DOSTARCZONE);

        assertThat(orderService.confirmOrder(1)).isNotNull();
    }

    @Test
    void notConfirmOrderTest(){
        productStorage.addProduct(product1);
        productStorage.addProduct(product2);
        productStorage.addProduct(product3);

        orderShoppingCart.addProduct(product1, 5);
        orderShoppingCart.addProduct(product3,1);
        orderService.createOrder(12,orderShoppingCart,"xyz");

        assertThat(orderService.confirmOrder(1)).isNull();
    }

}
