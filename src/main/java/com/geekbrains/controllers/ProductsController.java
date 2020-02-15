package com.geekbrains.controllers;

import javax.servlet.http.HttpServletRequest;
import com.geekbrains.entities.Product;
import com.geekbrains.entities.Student;
import com.geekbrains.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductsController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService){this.productService=productService;}

    // http://localhost:8085/app/students/showForm
    @RequestMapping("/showProdForm")
    public String showProdForm(Model model){
        Product product=new Product();
        model.addAttribute("product", product);
        return "product-form";
    }

    // http://localhost:8085/app/students/processForm
    @RequestMapping("/processProdForm")
    public String processProdForm(@ModelAttribute("product") Product product) {
        System.out.println("Firm: "+product.getFirmProd());
        System.out.println("Model: " + product.getProductModel());
        System.out.println("Price: "+product.getPrice());
        System.out.println("Article:  "+product.getArticle());
        return "product-form-result";
    }

    // http://localhost:8085/app/students/showStudentById?id=5
    @RequestMapping(path="/showProdByArticle", method=RequestMethod.GET)
    public String showProdByArticle(Model model, @RequestParam int article) {
        Product product = productService.getProductByArticle(article);
        model.addAttribute("product", product);
        return "product-form-result";
    }

    // http://localhost:8085/app/students/getStudentById?id=20
    @RequestMapping(path="/getProductByArticle", method=RequestMethod.GET)
    @ResponseBody
    public Product getProductByArticle(@RequestParam int article){
        Product product=productService.getProductByArticle(article);
        return product;
    }

    // http://localhost:8085/app/students/getStudentById/10
    @RequestMapping(path="/getProductByArticle/{sart}", method=RequestMethod.GET)
    @ResponseBody
    public Product getProductByArticleFromPath(@PathVariable("sart") int article) {
        Product product=productService.getProductByArticle(article);
        return product;
    }
}
