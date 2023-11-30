package elte.project.pcbuilder.domain.user;

import elte.project.pcbuilder.domain.components.PCComponent;
import jakarta.persistence.*;

@Entity
@Table(name = "Order_Item")
public class OrderItem {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private PCComponent pcComponent;
    private int amount;
    @ManyToOne
    private Order order;

    public OrderItem() {
    }

    public OrderItem(PCComponent pcComponent, int amount) {
        this.pcComponent = pcComponent;
        this.amount = amount;
    }

    public PCComponent getPcComponent() {
        return pcComponent;
    }

    public void setPcComponent(PCComponent pcComponent) {
        this.pcComponent = pcComponent;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
