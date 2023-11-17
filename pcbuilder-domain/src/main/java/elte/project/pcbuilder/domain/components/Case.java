package elte.project.pcbuilder.domain.components;

import elte.project.pcbuilder.domain.enums.SizeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Cases")
public class Case extends PCComponent {

    private SizeType sizeType;

    public SizeType getSizeType() {
        return sizeType;
    }

    public void setSizeType(SizeType sizeType) {
        this.sizeType = sizeType;
    }
}
