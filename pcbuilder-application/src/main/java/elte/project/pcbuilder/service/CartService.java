package elte.project.pcbuilder.service;

import elte.project.pcbuilder.domain.components.PCComponent;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.math.BigDecimal;
import java.util.*;

@Service
public class CartService {
    public BigDecimal calculateTotalPrice(List<PCComponent> pcComponents){
        BigDecimal sum=BigDecimal.ZERO;
        for(PCComponent item : pcComponents){
            sum = sum.add(item.getPrice());
        }
        return sum;
    }
}
