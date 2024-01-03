package elte.project.pcbuilder.domain.DTOs;

import java.util.List;

public class FilterDTO {
    List<String> brands;

    public List<String> getBrands() {
        return brands;
    }

    public void setBrands(List<String> brands) {
        this.brands = brands;
    }
}
