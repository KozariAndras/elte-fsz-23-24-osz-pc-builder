package elte.project.pcbuilder.repository;

import elte.project.pcbuilder.domain.user.Order;
import elte.project.pcbuilder.domain.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order,Integer> {
    Optional<Order> findOrderById(int id);
    List<Order> findOrdersByUser(User user);
}
