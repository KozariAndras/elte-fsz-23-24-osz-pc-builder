package elte.project.pcbuilder.domain.user;

import elte.project.pcbuilder.domain.enums.Role;
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
    @Enumerated(EnumType.STRING)
    private Role role;

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
