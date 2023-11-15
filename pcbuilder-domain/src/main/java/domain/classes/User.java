package domain.classes;

import jakarta.persistence.*;
import org.aspectj.weaver.ast.Or;

import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    private Credential credential;
    private String role;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
