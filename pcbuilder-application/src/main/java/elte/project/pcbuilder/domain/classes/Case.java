package elte.project.pcbuilder.domain.classes;

import elte.project.pcbuilder.domain.enums.SizeType;
import jakarta.persistence.Entity;

@Entity
public class Case extends PCComponent{

    private SizeType sizeType;

    public SizeType getSizeType() {
        return sizeType;
    }

    public void setSizeType(SizeType sizeType) {
        this.sizeType = sizeType;
    }
}
