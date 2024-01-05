package elte.project.pcbuilder.domain.DTOs;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

public class PCComponentDTO {
    private int id;
    private String name;
    private String brand;
    private BigDecimal price;
    private Integer quantity;

    public PCComponentDTO(){

    }

    public PCComponentDTO (int id, String name, String brand, BigDecimal price, Integer quantity){
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
