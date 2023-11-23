package elte.project.pcbuilder.service;

import elte.project.pcbuilder.domain.components.PCComponent;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartService {

    public void add(PCComponent component,List<PCComponent>  cartItems){
        if(!cartItems.contains(component)){
            cartItems.add(component);
        }
    }

    public BigDecimal calculateTotalPrice(List<PCComponent> cartItems){
        BigDecimal sum = new BigDecimal(0);
        for (PCComponent component : cartItems){
            sum = sum.add(component.getPrice());
        }
        return sum;
    }

}
