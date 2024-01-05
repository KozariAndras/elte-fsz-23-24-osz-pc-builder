package elte.project.pcbuilder.domain.DTOs;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotEmpty;

import java.math.BigDecimal;
import java.util.List;

public class FilterDTO {

    private List<String> brands;
    private BigDecimal min;
    private BigDecimal max;


    public List<String> getBrands() {
        return brands;
    }

    public void setBrands(List<String> brands) {
        this.brands = brands;
    }

    public BigDecimal getMin() {
        return min;
    }

    public void setMin(BigDecimal min) {
        this.min = min;
    }

    public BigDecimal getMax() {
        return max;
    }

    public void setMax(BigDecimal max) {
        this.max = max;
    }

    @AssertTrue
    public boolean isAtLeastOneFieldProvided(){
        return min != null && max != null && min.compareTo(max) == -1|| !brands.isEmpty();
    }
}
