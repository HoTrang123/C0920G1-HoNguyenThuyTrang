package com.codegym.model;

public class Product {
    private int id;
    private String name;
    private int price;
    private String img;
    private int quantity;

    public Product(int id, String name, int price, String img, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.img = img;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
