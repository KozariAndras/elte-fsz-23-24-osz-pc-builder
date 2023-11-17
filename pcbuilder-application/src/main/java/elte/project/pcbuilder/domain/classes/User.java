package elte.project.pcbuilder.domain.classes;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Users")
public class User {

    @Id
    @GeneratedValue
    private int id;
    @OneToOne(mappedBy = "user")
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
