package com.geekbrains.spring_demo4.services;


import com.geekbrains.spring_demo4.entities.Product;
import com.geekbrains.spring_demo4.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    private ProductsRepository productsRepository;

    @Autowired
    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Product> getAllProd(){
        return (List<Product>)productsRepository.findAll();
    }


    public Page<Product> getAllByPrice(int page, int size){
        return productsRepository.findAll(PageRequest.of(page, size));

    }



    public List<Product> getMinPrice(int price){
        return productsRepository.getFirstByPriceOrderByPriceDesc(price);//findAllByPriceOrderByPricePriceDesc();
    }

    public List<Product> getMaxPrice(int price){
        return productsRepository.getFirstByPriceOrderByPriceAsc(price);//findAllByPriceOrderByPriceAsc();
    }

    public List<Product> getMinAndMaxPrice(Integer price1, Integer price2){
        return productsRepository.findAllByPriceIsBetween(price1, price2);
    }
}
