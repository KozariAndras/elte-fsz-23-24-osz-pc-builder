package elte.project.pcbuilder.domain.user;

import elte.project.pcbuilder.domain.components.PCComponent;
import elte.project.pcbuilder.domain.user.User;
import jakarta.persistence.*;

import java.util.List;
import java.util.Map;

@Entity
@Table(name="Orders")
public class Order {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private User user;
    private String status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<PCComponent>  getPcComponents() {
        return pcComponents;
    }

    public void setPcComponents(List<PCComponent>  pcComponents) {
        this.pcComponents = pcComponents;
    }
}
