package com.example.ZakupyOnline;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductStorage {

    static List<Product> productList = new ArrayList<>();


    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        ProductStorage.productList = productList;
    }

    public void addProduct(Product product){
        productList.add(product);
    }
}
