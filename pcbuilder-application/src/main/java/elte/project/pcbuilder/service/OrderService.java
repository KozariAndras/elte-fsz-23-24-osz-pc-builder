package elte.project.pcbuilder.service;

import elte.project.pcbuilder.domain.user.OrderItem;
import elte.project.pcbuilder.domain.user.Order;
import elte.project.pcbuilder.domain.user.User;
import elte.project.pcbuilder.repository.CartItemRepository;
import elte.project.pcbuilder.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CartItemRepository cartItemRepository;

    public void create(List<OrderItem> items, User user){
        Order order = new Order();
        order.setStatus("Incomplete");
        order.setUser(user);
        order.setCartItems(items);

        orderRepository.save(order);
        items.forEach(cartItem -> {
            cartItem.setOrder(order);
            cartItemRepository.save(cartItem);
        });

    }

    public void remove(Order order){
        orderRepository.delete(order);
    }

    public void completeOrder(int id){
        Optional<Order> order = orderRepository.findOrderById(id);
        if(order.isPresent()){
            order.get().setStatus("Completed");
            orderRepository.save(order.get());
        }
    }

}
