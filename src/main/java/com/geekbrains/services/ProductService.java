package com.geekbrains.services;

import com.geekbrains.entities.Product;
import com.geekbrains.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductByArticle(int article){
        Product product=productRepository.findProductByArticle(article);
        return product;
    }

    public ArrayList<Product> getProducts(){
        return productRepository.findProdList();
    }

    public Product saveProd(Product product){
        if(product==null) return null;
        return productRepository.saveProduct(product);
    }
}
