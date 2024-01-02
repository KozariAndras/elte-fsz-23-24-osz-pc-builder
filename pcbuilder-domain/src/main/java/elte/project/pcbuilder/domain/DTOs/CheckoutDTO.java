package elte.project.pcbuilder.domain.DTOs;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class CheckoutDTO {

    private List<PCComponentDTO> items;
    private BigDecimal totalPrice;

    public CheckoutDTO(){

    }

    public CheckoutDTO(BigDecimal total){
        this.items = new ArrayList<>();
        this.totalPrice = total;
    }

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

    public List<Integer> getIds() {
        return items.stream().map(PCComponentDTO::getId).toList();
    }

}
