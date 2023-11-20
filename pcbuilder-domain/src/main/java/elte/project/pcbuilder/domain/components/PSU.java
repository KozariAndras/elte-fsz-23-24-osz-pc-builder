package elte.project.pcbuilder.domain.components;

import elte.project.pcbuilder.domain.components.PCComponent;
import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class PSU extends PCComponent {

    private String rating;
    private int performance;

    public PSU(String name, String brand, BigDecimal price, String rating, int performance) {
        super(name, brand, price);
        this.rating = rating;
        this.performance = performance;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }
}
