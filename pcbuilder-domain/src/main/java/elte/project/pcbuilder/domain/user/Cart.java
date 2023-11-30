package elte.project.pcbuilder.domain.user;

import java.util.List;

//@Entity
//@Table(name="Carts")
public class Cart {

//    @Id
//    @GeneratedValue
    private int id;

//    @OneToMany
    private List<OrderItem> orderItems;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<OrderItem> getCartItems() {
        return orderItems;
    }

    public void setCartItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
