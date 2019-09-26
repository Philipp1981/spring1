package com.geekbrains.septembermarket.utils;


import com.geekbrains.septembermarket.entities.CartProduct;
import com.geekbrains.septembermarket.entities.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {
//    private List<Product> products;
//
//    public List<Product> getProducts() {
//        return products;
//    }

    private HashMap<Product, CartProduct> cartProductHashMap;
    private int totalPrice;

    public HashMap<Product, CartProduct> getCartProductHashMap() {
        return cartProductHashMap;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    @PostConstruct
    public void init(){
//        products=new ArrayList<>();
        cartProductHashMap=new HashMap<>();
        totalPrice=0;
    }

    public void addProduct(Product product) {
        if (!cartProductHashMap.containsKey(product)) {
            CartProduct cartProduct = new CartProduct(product.getId(), product.getTitle(), product.getPrice(), 1);
            cartProductHashMap.put(product, cartProduct);
        } else {
            CartProduct cartProduct = cartProductHashMap.get(product);
            cartProduct.setCount(cartProduct.getCount() + 1);
        }
  //          totalPrice=product.getPrice()*cartProduct.getCount();
    }

    public void deleteProduct(Product product) {
        CartProduct cartProduct=new CartProduct(product.getId(), product.getTitle(), product.getPrice(), 1);
        if(cartProduct.getCount()<=1) {
            cartProductHashMap.remove(product, cartProduct);
        }
        else {
            cartProduct.setCount(cartProduct.getCount()-1);
           }
 //       totalPrice=cartProduct.getPrice()*cartProduct.getCount();
    }

    public int overallPrice(HashMap<Product, CartProduct> cartProductHashMap){
        int price=0;
        for (Map.Entry<Product, CartProduct> map : cartProductHashMap.entrySet()) {
            price += map.getValue().getPrice() * map.getValue().getCount();
        }
            return price;
    }
}
