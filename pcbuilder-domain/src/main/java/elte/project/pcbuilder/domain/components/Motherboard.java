package elte.project.pcbuilder.domain.components;

import elte.project.pcbuilder.domain.enums.CPUSocket;
import elte.project.pcbuilder.domain.enums.RamSocketType;
import elte.project.pcbuilder.domain.enums.SizeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Motherboard extends PCComponent {

    private String chipset;

    @Enumerated(EnumType.STRING)
    private SizeType sizeType;

    @Enumerated(EnumType.STRING)
    private RamSocketType ramSocketType;

    @Enumerated(EnumType.STRING)
    private CPUSocket cpuSocket;

    public Motherboard() {
    }

    public Motherboard(String name, String brand, BigDecimal price, String chipset, SizeType sizeType, RamSocketType ramSocketType, CPUSocket cpuSocket) {
        super(name, brand, price);
        this.chipset = chipset;
        this.sizeType = sizeType;
        this.ramSocketType = ramSocketType;
        this.cpuSocket = cpuSocket;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public SizeType getSizeType() {
        return sizeType;
    }

    public void setSizeType(SizeType sizeType) {
        this.sizeType = sizeType;
    }

    public RamSocketType getRamSocketType() {
        return ramSocketType;
    }
    public void setRamSocketType(RamSocketType ramSocketType) {
        this.ramSocketType = ramSocketType;
    }

    public CPUSocket getCpuSocket() {
        return cpuSocket;
    }

    public void setCpuSocket(CPUSocket cpuSocket) {
        this.cpuSocket = cpuSocket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Motherboard that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(chipset, that.chipset) && sizeType == that.sizeType && ramSocketType == that.ramSocketType && cpuSocket == that.cpuSocket;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), chipset, sizeType, ramSocketType, cpuSocket);
    }
}
