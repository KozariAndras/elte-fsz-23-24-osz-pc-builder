package elte.project.pcbuilder.domain.user;

import elte.project.pcbuilder.domain.components.PCComponent;
import jakarta.persistence.*;

import java.util.List;

//@Entity
//@Table(name="Carts")
public class Cart {

//    @Id
//    @GeneratedValue
    private int id;

//    @OneToMany
    private List<PCComponent> pcComponents;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<PCComponent> getPcComponents() {
        return pcComponents;
    }

    public void setPcComponents(List<PCComponent> pcComponents) {
        this.pcComponents = pcComponents;
    }
}
