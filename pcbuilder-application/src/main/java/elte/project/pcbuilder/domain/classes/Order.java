package elte.project.pcbuilder.domain.classes;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Order {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private User user;
    private String status;
    @OneToMany
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<PCComponent> getPcComponents() {
        return pcComponents;
    }

    public void setPcComponents(List<PCComponent> pcComponents) {
        this.pcComponents = pcComponents;
    }
}
