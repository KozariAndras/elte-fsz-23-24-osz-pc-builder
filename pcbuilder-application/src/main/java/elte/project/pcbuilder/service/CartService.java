package elte.project.pcbuilder.service;

import elte.project.pcbuilder.domain.components.PCComponent;
import elte.project.pcbuilder.domain.user.OrderItem;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class CartService {
    private List<OrderItem> orderItems = new ArrayList<>();

    public void add(PCComponent component){
        Optional<OrderItem> foundCartItem = orderItems.stream().findAny().filter(cartItem -> cartItem.getPcComponent().equals(component));
        if(foundCartItem.isPresent()){
            int oldAmount = foundCartItem.get().getAmount();
            foundCartItem.get().setAmount(oldAmount + 1);
        } else {
            OrderItem newOrderItem = new OrderItem();
            newOrderItem.setPcComponent(component);
            newOrderItem.setAmount(1);
            orderItems.add(newOrderItem);
        }
    }

    public BigDecimal calculateTotalPrice(){
        BigDecimal sum=BigDecimal.ZERO;
        for(OrderItem item : orderItems){
            BigDecimal totalPriceOfItem = item.getPcComponent().getPrice().multiply(BigDecimal.valueOf(item.getAmount()));
            sum = sum.add(totalPriceOfItem);
        }
        return sum;
    }

    public List<OrderItem> getCartItems() {
        return orderItems;
    }

    public void setCartItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
