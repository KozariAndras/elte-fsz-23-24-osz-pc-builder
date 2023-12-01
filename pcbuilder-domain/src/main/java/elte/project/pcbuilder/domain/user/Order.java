package elte.project.pcbuilder.domain.user;

import elte.project.pcbuilder.domain.enums.OrderStatusType;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Orders")
public class Order {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private User user;
    @Enumerated(EnumType.STRING)
    private OrderStatusType status;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OrderStatusType getStatus() {
        return status;
    }

    public void setStatus(OrderStatusType status) {
        this.status = status;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
