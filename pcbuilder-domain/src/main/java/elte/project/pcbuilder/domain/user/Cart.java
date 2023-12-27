package elte.project.pcbuilder.domain.user;

import elte.project.pcbuilder.domain.components.PCComponent;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<PCComponent> pcComponents;

    public Cart() {
        this.pcComponents = new ArrayList<>();
    }

    public List<PCComponent> getPcComponents() {
        return pcComponents;
    }

    public void setPcComponents(List<PCComponent> pcComponents) {
        this.pcComponents = pcComponents;
    }
}
