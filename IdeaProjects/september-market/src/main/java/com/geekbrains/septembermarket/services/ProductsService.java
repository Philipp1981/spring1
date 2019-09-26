package com.geekbrains.septembermarket.services;

import com.geekbrains.septembermarket.entities.Product;
import com.geekbrains.septembermarket.repositories.ProductsRepository;
import errors_handlers.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductsService {
    private ProductsRepository productsRepository;

    @Autowired
    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public Page<Product> findAllByPagingAndFiltering(Specification<Product> specification, Pageable pageable) {
        return productsRepository.findAll(specification, pageable);
    }

    public List<Product> findProducts(){
        return productsRepository.findAll();
    }

    public Product save(Product product) {
        return productsRepository.save(product);
    }

    public Product saveOrUpdate(Product product, Long id) {
        product= productsRepository.findById(id).orElse(null);
        if(product==null) throw new ResourceNotFoundException("Product not found: "+id);
        return product;
    }

    public void delete(Product product) {
        productsRepository.delete(product);
    }

    public void deleteProductById(Long id) {
        productsRepository.deleteById(id);
    }


    public Product findById(Long id) {
        return productsRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Product not found: "+id));//get();
    }

}
