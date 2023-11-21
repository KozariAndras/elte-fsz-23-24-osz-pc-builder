package elte.project.pcbuilder.repository;

import elte.project.pcbuilder.domain.user.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,Integer> {
}
