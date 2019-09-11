package com.geekbrains.spring_demo4.repositories;


import com.geekbrains.spring_demo4.entities.Product;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ProductsRepository extends PagingAndSortingRepository<Product, Long> {

    List<Product> getFirstByPriceOrderByPriceAsc(int price);
    List<Product> getFirstByPriceOrderByPriceDesc(int price);
    List<Product> findAllByPriceIsBetween(Integer price1, Integer price2);

}
