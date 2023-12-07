package elte.project.pcbuilder.domain.components;

import elte.project.pcbuilder.domain.components.PCComponent;
import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class PSU extends PCComponent {

    private String rating;
    private int performance;

    public PSU() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PSU psu)) return false;
        if (!super.equals(o)) return false;
        return performance == psu.performance && Objects.equals(rating, psu.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rating, performance);
    }
}
