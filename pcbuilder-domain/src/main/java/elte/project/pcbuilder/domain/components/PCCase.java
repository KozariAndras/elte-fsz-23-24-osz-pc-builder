package elte.project.pcbuilder.domain.components;

import elte.project.pcbuilder.domain.enums.SizeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name="Cases")
public class PCCase extends PCComponent {
    @Enumerated(EnumType.STRING)
    private SizeType sizeType;

    public PCCase() {
    }

    public PCCase(String brand,String name,BigDecimal price, SizeType sizeType) {
        super(name, brand, price);
        this.sizeType = sizeType;
    }

    public SizeType getSizeType() {
        return sizeType;
    }

    public void setSizeType(SizeType sizeType) {
        this.sizeType = sizeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PCCase pcCase)) return false;
        if (!super.equals(o)) return false;
        return sizeType == pcCase.sizeType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sizeType);
    }
}
