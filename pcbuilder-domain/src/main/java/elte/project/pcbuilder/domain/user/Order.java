package elte.project.pcbuilder.domain.user;

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
    private String status;
    @OneToMany(mappedBy = "order")
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderItem> getCartItems() {
        return orderItems;
    }

    public void setCartItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
