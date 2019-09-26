package com.geekbrains.septembermarket.utils;

import com.geekbrains.septembermarket.entities.Product;
import com.geekbrains.septembermarket.repositories.specifications.ProductSpecifications;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpRequest;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class ProductFilter {
    private Specification<Product> specification;
    private StringBuilder filterString;


    public Specification<Product> getSpecification() {
        return specification;
    }

    public StringBuilder getFilterString() {
        return filterString;
    }

    public ProductFilter(HttpServletRequest request) {
        filterString=new StringBuilder();
        specification=Specification.where(null);

        if (request.getParameter("word") != null && !request.getParameter("word").isEmpty()) {
            specification = specification.and(ProductSpecifications.titleContains(request.getParameter("word")));
            filterString.append("&word=" + request.getParameter("word"));
        }

        if (request.getParameter("min") != null && !request.getParameter("min").isEmpty()) {
            specification = specification.and(ProductSpecifications.priceGreaterThanOrEq(Double.parseDouble(request.getParameter("min"))));
            filterString.append("&min=" + request.getParameter("min"));
        }

        if (request.getParameter("max") != null && !request.getParameter("max").isEmpty()) {
            specification = specification.and(ProductSpecifications.priceLesserThanOrEq(Double.parseDouble(request.getParameter("max"))));
            filterString.append("&max=" + request.getParameter("max"));
        }

    }
}
