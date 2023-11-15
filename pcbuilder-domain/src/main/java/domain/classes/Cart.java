package domain.classes;

import java.util.List;

public class Cart {

    private int id;
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
