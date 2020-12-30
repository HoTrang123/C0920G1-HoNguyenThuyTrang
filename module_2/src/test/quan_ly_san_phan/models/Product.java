package test.quan_ly_san_phan.models;

import java.util.ArrayList;
import java.util.List;

public abstract class Product {
    protected String id;
    protected String productId;
    protected String productName;
    protected String productPrice;
    protected String productNumber;
    protected String producer;

    public Product() {
    }

    public Product(String id, String productId, String productName, String productPrice, String productNumber, String producer) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productNumber = productNumber;
        this.producer = producer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", productNumber='" + productNumber + '\'' +
                ", producer='" + producer + '\'' +
                '}';
    }
    public abstract void showIfo();
}
