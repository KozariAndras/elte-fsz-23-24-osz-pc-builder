package elte.project.pcbuilder.repository;

import elte.project.pcbuilder.domain.user.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order,Integer> {
    Optional<Order> findOrderById(int id);
}
