package com.geekbrains.septembermarket.controllers;

import com.geekbrains.septembermarket.entities.Product;
import com.geekbrains.septembermarket.repositories.specifications.ProductSpecifications;
import com.geekbrains.septembermarket.services.ProductsService;
import com.geekbrains.septembermarket.utils.ProductFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@Secured({"ROLE_ADMIN"})
@RequestMapping("/products")
public class ProductsController {
    private ProductsService productsService;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping()
    public String showProducts(Model model, HttpServletRequest request,
                               @RequestParam(name = "word", required = false) String word,
                               @RequestParam(name = "min", required = false) Integer min,
                               @RequestParam(name = "max", required = false) Integer max,
                               @RequestParam(name = "count", required = false) Integer count,
                               @RequestParam(name = "pageNumber", required = false) Integer pageNumber
    ) {
//        Specification<Product> spec = Specification.where(null);
//        StringBuilder filtersBuilder = new StringBuilder();
//        if (word != null && !word.isEmpty()) {
//            spec = spec.and(ProductSpecifications.titleContains(word));
//            filtersBuilder.append("&word=" + word);
//        }
//        if (min != null) {
//            spec = spec.and(ProductSpecifications.priceGreaterThanOrEq(min));
//            filtersBuilder.append("&min=" + min);
//        }
//        if (max != null) {
//            spec = spec.and(ProductSpecifications.priceLesserThanOrEq(max));
//            filtersBuilder.append("&max=" + max);
//        }

        ProductFilter productFilter = new ProductFilter(request);
        if (pageNumber == null || pageNumber < 1) {
            pageNumber = 1;
        }

        if(count==null||count<=0) count=3;

        if (pageNumber == null||pageNumber<1) {
            pageNumber = 1;
        }

        model.addAttribute("word", word);
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        model.addAttribute("count", count);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("filters", productFilter.getFilterString());

        Page<Product> page = productsService.findAllByPagingAndFiltering(productFilter.getSpecification(), PageRequest.of(pageNumber - 1, count, Sort.Direction.ASC, "id"));
        model.addAttribute("page", page);
        return "products";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(Model model, @PathVariable(name = "id") Long id) {
        Product product = productsService.findById(id);
        model.addAttribute("product", product);
        return "edit_product";
    }

    @PostMapping("/edit")
    public String saveModifiedProduct(@ModelAttribute(name = "product") Product product) {
        productsService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@ModelAttribute(name = "product") Product product) {
        productsService.delete(product);
        return "redirect:/products";
    }

    @GetMapping("/add")
    public String showAddForm(Model model, @ModelAttribute(name = "product") Product product) {
        productsService.save(product);
        model.addAttribute("product", product);
        return "add_product";
    }

    @PostMapping("/add")
    public String saveNewProduct(@ModelAttribute(name = "product") Product product) {
        productsService.save(product);
        return "redirect:/products";
    }
    @GetMapping("/admin")
    public String showAdminPage() {
        return "products";
    }
}
