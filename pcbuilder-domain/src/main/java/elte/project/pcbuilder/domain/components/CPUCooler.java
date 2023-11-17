package elte.project.pcbuilder.domain.components;

import elte.project.pcbuilder.domain.enums.CPUSocket;
import elte.project.pcbuilder.domain.enums.CoolerType;
import jakarta.persistence.Entity;

@Entity
public class CPUCooler extends PCComponent {

    private int noise;
    private int radius;
    private int speed;
    private CoolerType coolerType;
    private CPUSocket cpuSocket;

    public int getNoise() {
        return noise;
    }

    public void setNoise(int noise) {
        this.noise = noise;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public CoolerType getCoolerType() {
        return coolerType;
    }

    public void setCoolerType(CoolerType coolerType) {
        this.coolerType = coolerType;
    }

    public CPUSocket getCpuSocket() {
        return cpuSocket;
    }

    public void setCpuSocket(CPUSocket cpuSocket) {
        this.cpuSocket = cpuSocket;
    }
}
