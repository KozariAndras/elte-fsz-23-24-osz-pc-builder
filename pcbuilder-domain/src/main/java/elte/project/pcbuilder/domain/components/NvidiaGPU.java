package elte.project.pcbuilder.domain.components;

import elte.project.pcbuilder.domain.enums.NvidiaGPUSeries;
import elte.project.pcbuilder.domain.components.GPU;
import jakarta.persistence.Entity;

@Entity
public class NvidiaGPU extends GPU {

    private NvidiaGPUSeries nvidiaGPU;

    public NvidiaGPUSeries getNvidiaGPU() {
        return nvidiaGPU;
    }

    public void setNvidiaGPU(NvidiaGPUSeries nvidiaGPU) {
        this.nvidiaGPU = nvidiaGPU;
    }
}
