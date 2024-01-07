package elte.project.pcbuilder.service;

import elte.project.pcbuilder.domain.components.PCComponent;
import elte.project.pcbuilder.domain.enums.OrderStatusType;
import elte.project.pcbuilder.domain.user.Order;
import elte.project.pcbuilder.domain.user.User;
import elte.project.pcbuilder.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public void create(List<PCComponent> items, User user){
        Order order = new Order();
        order.setStatus(OrderStatusType.INCOMPLETE);
        order.setUser(user);
        order.setPcComponents(items);
        orderRepository.save(order);
        items.clear();

    }

    public void remove(Order order){
        orderRepository.delete(order);
    }

    @Transactional
    public List<Order> getOrdersByUser(User user){
        List<Order> orderList = orderRepository.findOrdersByUser(user);
        orderList.forEach(order -> order.getPcComponents().size());
        return orderList;
    }


}
