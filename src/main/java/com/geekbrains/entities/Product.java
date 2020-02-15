package com.geekbrains.entities;

public class Product {
    private String firmProd;
    private String productModel;
    private int price;
    private int article;

    public Product() {
    }

    public Product(int article){
        this.firmProd=firmProd;
        this.productModel=productModel;
        this.price=price;
        this.article=article;
    }

    public Product(String firmProd, String productModel, int price, int article){
        this.firmProd=firmProd;
        this.productModel=productModel;
        this.price=price;
        this.article=article;
    }

    public String getFirmProd() {
        return firmProd;
    }
    public void setFirmProd(String firmProd) {
        this.firmProd = firmProd;
    }

    public String getProductModel() { return productModel; }
    public void setProductModel(String productModel) {this.productModel = productModel; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public int getArticle() { return article; }
    public void setArticle(int article) {this.article = article;}
}
