package elte.project.pcbuilder.repository;

import elte.project.pcbuilder.domain.user.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface CartItemRepository extends CrudRepository<OrderItem,Integer> {
}
