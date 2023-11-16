package elte.project.pcbuilder.domain.classes;

import elte.project.pcbuilder.domain.enums.NvidiaGPUSeries;
import jakarta.persistence.Entity;

@Entity
public class NvidiaGPU extends GPU{

    private NvidiaGPUSeries nvidiaGPU;

    public NvidiaGPUSeries getNvidiaGPU() {
        return nvidiaGPU;
    }

    public void setNvidiaGPU(NvidiaGPUSeries nvidiaGPU) {
        this.nvidiaGPU = nvidiaGPU;
    }
}
