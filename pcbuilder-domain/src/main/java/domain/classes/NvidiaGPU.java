package domain.classes;

import jakarta.persistence.Entity;

public class NvidiaGPU extends GPU{

    private NvidiaGPU nvidiaGPU;

    public NvidiaGPU getNvidiaGPU() {
        return nvidiaGPU;
    }

    public void setNvidiaGPU(NvidiaGPU nvidiaGPU) {
        this.nvidiaGPU = nvidiaGPU;
    }
}
