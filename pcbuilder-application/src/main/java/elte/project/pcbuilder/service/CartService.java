package elte.project.pcbuilder.service;

import elte.project.pcbuilder.domain.components.PCComponent;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class CartService {
    private List<PCComponent> pcComponents = new ArrayList<>();

    public void add(PCComponent component){
        pcComponents.add(component);
    }

    public BigDecimal calculateTotalPrice(){
        BigDecimal sum=BigDecimal.ZERO;
        for(PCComponent item : pcComponents){
            sum = sum.add(item.getPrice());
        }
        return sum;
    }

    public List<PCComponent> getPcComponents() {
        return pcComponents;
    }

    public void setPcComponents(List<PCComponent> pcComponents) {
        this.pcComponents = pcComponents;
    }
}
