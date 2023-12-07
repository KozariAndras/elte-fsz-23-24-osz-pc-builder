package elte.project.pcbuilder.domain.user;

import elte.project.pcbuilder.domain.components.PCComponent;
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
    @ManyToMany
    private List<PCComponent> pcComponents;

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

    public List<PCComponent> getPcComponents() {
        return pcComponents;
    }

    public void setPcComponents(List<PCComponent> pcComponents) {
        this.pcComponents = pcComponents;
    }
}
