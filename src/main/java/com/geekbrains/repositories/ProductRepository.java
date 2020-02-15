package com.geekbrains.repositories;

import com.geekbrains.entities.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Component
public class ProductRepository {

    private ArrayList<Product> prodList=new ArrayList<Product>();

    @PostConstruct
    public void init(){
        prodList.add(new Product("Sony", "TV01", 200, 01333));
        prodList.add(new Product("Apple", "Iphone 8", 1000, 02337));
        prodList.add(new Product("Samsung", "Galaxy9", 800, 03335));
        prodList.add(new Product("Huavei", "P20", 900, 044553));
        prodList.add(new Product("Xiaomi", "Mi mix2", 600, 05621));
    }

    public Product findProductByArticle(int article) {
        for(Product prod: prodList){
            if(prod.getArticle()==article) {
                return prod;
            } else System.out.println("No such product");
        }
        return null;
    }

    public ArrayList<Product> findProdList(){ return prodList;}

    public Product saveProduct(Product product){
        prodList.add(product);
        return product;
    }


}
