package com.geekbrains.spring_demo4.controllers;


import com.geekbrains.spring_demo4.entities.Product;
import com.geekbrains.spring_demo4.repositories.ProductsRepository;
import com.geekbrains.spring_demo4.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {


    private ProductsService productsService;

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/products")
    public String showProducts(Model model){
        List<Product> productList=productsService.getAllProd();
        model.addAttribute("products", productList);
        return "products";
    }


    @RequestMapping("/productPage")
    public String showProductPage(Model model) {
        Page<Product> productPage = productsService.getAllByPrice(2, 5);
        model.addAttribute("products", productPage);
        return "products";
    }

    //http://localhost:8289/app/minPriceProd?price=30000
    @RequestMapping(path = "/minPriceProd", method = RequestMethod.GET)
    @ResponseBody
    public List<Product> showMinPriceProd(@RequestParam int price) {
        return productsService.getMinPrice(price);
    }

//http://localhost:8289/app/maxPriceProd?price=150000
    @RequestMapping(path = "/maxPriceProd", method = RequestMethod.GET)
    @ResponseBody
    public List<Product> showMaxPriceProd(@RequestParam int price) {
        return productsService.getMaxPrice(price);
 //       return productsRepository.findAllByPriceOrderByPriceAsc();
    }


    @GetMapping("/submit_form")
    @ResponseBody
    public  List<Product> showMinmaxPriceProd(@RequestParam (value = "min_price", required = false) Integer price1,
                                              @RequestParam (value = "max_price", required = false) Integer price2) {
        if(price1==null) price1=0;
        if(price2==null) price2=Integer.MAX_VALUE;
        return productsService.getMinAndMaxPrice(price1, price2);
    }
}
