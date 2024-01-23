package com.example.ZakupyOnline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZakupyOnlineApplication {

	public static void main(String[] args) {

		SpringApplication.run(ZakupyOnlineApplication.class, args);
	}

	public final OrderService orderService;
	public final ProductStorage productStorage;
	public final OrderStorage orderStorage;
	ZakupyOnlineApplication(OrderService orderService, ProductStorage productStorage, OrderStorage orderStorage){
		this.orderService = orderService;
		this.productStorage = productStorage;
		this.orderStorage = orderStorage;

		init_process();
	}

	public void init_process(){
		Product product1= new Product(1,"koszulka",100);
		Product product2= new Product(2,"spodnie",150);
		Product product3= new Product(3,"bluza",120);
		Product product4= new Product(4,"kurtka",300);

		ProductStorage.productList.add(product1);
		ProductStorage.productList.add(product2);
		ProductStorage.productList.add(product3);
		ProductStorage.productList.add(product4);

		OrderShoppingCart shoppingCart = new OrderShoppingCart();
		shoppingCart.addProduct(product1,2);
		//shoppingCart.addProduct(new Product(4,"buty",250),1);
		orderService.createOrder(123,shoppingCart,"xyz");

		orderService.checkOrder(1);
		Order nw=orderService.cancelOrder(1);
		nw.setOrderStatus(Status.W_REALIZACJI);
		Order ww = orderService.confirmOrder(1);

	}
}
