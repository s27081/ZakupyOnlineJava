package com.example.ZakupyOnline;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductStorage {

    static List<Product> productList = new ArrayList<>();


    public static List<Product> getProductList() {
        return productList;
    }

    public static void setProductList(List<Product> productList) {
        ProductStorage.productList = productList;
    }
}
