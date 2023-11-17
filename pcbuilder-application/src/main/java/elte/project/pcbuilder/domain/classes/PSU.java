package elte.project.pcbuilder.domain.classes;

import jakarta.persistence.Entity;

@Entity
public class PSU extends PCComponent{

    private String rating;
    private int performance;


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
