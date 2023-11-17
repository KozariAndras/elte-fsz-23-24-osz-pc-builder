package elte.project.pcbuilder.domain.components;

import jakarta.persistence.*;

import java.math.BigDecimal;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PCComponent {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String brand;
    private BigDecimal price;


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
}
