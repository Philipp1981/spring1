package com.geekbrains.septembermarket.controllers;


import com.geekbrains.septembermarket.entities.Product;
import com.geekbrains.septembermarket.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/products")
public class ProdRestController {

    private ProductsService productsService;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/")
    public List<Product> findProd(){
        return productsService.findProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productsService.findById(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product) {
        product.setId(0L);
        return productsService.save(product);
    }

    @PutMapping(path = "/products", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Product updateProduct(@RequestBody Product product) {
        return productsService.save(product);
    }

    @PutMapping("/{id}")
    public Product saveOrUpdate(@RequestBody Product newProduct, @PathVariable Long id){
        Product product=productsService.findById(id);
        if(product!=null){
            product.setTitle(newProduct.getTitle());
            product.setPrice(newProduct.getPrice());
        } else {
            product=newProduct;
            product.setId(id);
        } return productsService.save(product);
    }

    @DeleteMapping("/products/{id}")
    public int delProdById(@PathVariable Long id) {
        productsService.deleteProductById(id);
        return HttpStatus.OK.value();
    }

//    @DeleteMapping("/products/{product}")
//    public int delProdByTitle(@PathVariable Product product) {
//        productsService.delete(product);
//        return HttpStatus.OK.value();
//    }
}
