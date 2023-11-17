package elte.project.pcbuilder.domain.components;

import elte.project.pcbuilder.domain.enums.CPUSocket;
import elte.project.pcbuilder.domain.enums.RamSocketType;
import elte.project.pcbuilder.domain.enums.SizeType;
import jakarta.persistence.Entity;

@Entity
public class Motherboard extends PCComponent {

    private String chipset;

    private SizeType sizeType;

    private RamSocketType ramSocketType;

    private CPUSocket cpuSocket;



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
}
