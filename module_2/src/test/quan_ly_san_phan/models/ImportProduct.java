package test.quan_ly_san_phan.models;

import javax.management.AttributeList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ImportProduct extends Product {
    private String importPrice;
    private String importCity;
    private String importTax;

    public ImportProduct() {
    }

    public ImportProduct(String importPrice, String importCity, String importTax) {
        this.importPrice = importPrice;
        this.importCity = importCity;
        this.importTax = importTax;
    }

    public ImportProduct(String id, String productId, String productName, String productPrice, String productNumber,
                         String producer, String importPrice, String importCity, String importTax) {
        super(id, productId, productName, productPrice, productNumber, producer);
        this.importPrice = importPrice;
        this.importCity = importCity;
        this.importTax = importTax;
    }


    public String getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(String importPrice) {
        this.importPrice = importPrice;
    }

    public String getImportCity() {
        return importCity;
    }

    public void setImportCity(String importCity) {
        this.importCity = importCity;
    }

    public String getImportTax() {
        return importTax;
    }

    public void setImportTax(String importTax) {
        this.importTax = importTax;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "importPrice='" + importPrice + '\'' +
                ", importCity='" + importCity + '\'' +
                ", importTax='" + importTax + '\'' +
                '}';
    }

    @Override
    public void showIfo() {
        System.out.println(this.toString());
    }
}
