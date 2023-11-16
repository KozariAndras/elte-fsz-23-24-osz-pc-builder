package domain.classes;

import domain.enums.SizeType;
import jakarta.persistence.Entity;

public class Case extends PCComponent{

    private SizeType sizeType;

    public SizeType getSizeType() {
        return sizeType;
    }

    public void setSizeType(SizeType sizeType) {
        this.sizeType = sizeType;
    }
}
