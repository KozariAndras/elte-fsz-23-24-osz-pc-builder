package elte.project.pcbuilder.domain.DTOs;

import java.math.BigDecimal;
import java.util.List;

public class CheckoutDTO {

    private List<PCComponentDTO> items;
    private BigDecimal totalPrice;


    public List<PCComponentDTO> getItems() {
        return items;
    }

    public void setItems(List<PCComponentDTO> items) {
        this.items = items;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
