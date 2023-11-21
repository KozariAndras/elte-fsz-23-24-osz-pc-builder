package elte.project.pcbuilder.domain.components;

import elte.project.pcbuilder.domain.enums.CPUSocket;
import elte.project.pcbuilder.domain.enums.CoolerType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;

@Entity
public class CPUCooler extends PCComponent {

    private int noise;
    private int radius;
    private int speed;
    @Enumerated(EnumType.STRING)
    private CoolerType coolerType;

    public CPUCooler(String name, String brand, BigDecimal price, int noise, int radius, int speed, CoolerType coolerType) {
        super(name, brand, price);
        this.noise = noise;
        this.radius = radius;
        this.speed = speed;
        this.coolerType = coolerType;
    }

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

}
