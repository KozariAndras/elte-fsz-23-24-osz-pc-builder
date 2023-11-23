package elte.project.pcbuilder.domain.components;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "PCComponents")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PCComponent {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String brand;
    private BigDecimal price;

    public PCComponent() {
    }

    public PCComponent(String name, String brand, BigDecimal price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PCComponent component)) return false;
        return id == component.id && Objects.equals(name, component.name) && Objects.equals(brand, component.brand) && Objects.equals(price, component.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, brand, price);
    }
}
