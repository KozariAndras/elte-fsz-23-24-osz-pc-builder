package elte.project.pcbuilder.service;

import elte.project.pcbuilder.domain.user.Cart;
import elte.project.pcbuilder.domain.user.Order;
import elte.project.pcbuilder.domain.user.User;
import elte.project.pcbuilder.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public void create(Cart cart, User user){
        Order order = new Order();
        order.setStatus("Incomplete");
        order.setUser(user);
        order.setPcComponents(cart.getPcComponents());
        orderRepository.save(order);
        cart = new Cart();
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
