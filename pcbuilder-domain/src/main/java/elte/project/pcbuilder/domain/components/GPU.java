package elte.project.pcbuilder.domain.components;

import elte.project.pcbuilder.domain.enums.GPUSeries;
import elte.project.pcbuilder.domain.enums.GPUType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;

@Entity
public class GPU extends PCComponent {

    private int clockSpeed;
    private int memorySize;
    @Enumerated(EnumType.STRING)
    private GPUType gpuType;
    @Enumerated(EnumType.STRING)
    private GPUSeries gpuSeries;

    public GPU() {
    }

    public GPU(String name, String brand, BigDecimal price, int clockSpeed, int memorySize, GPUType gpuType, GPUSeries gpuSeries) {
        super(name, brand, price);
        this.clockSpeed = clockSpeed;
        this.memorySize = memorySize;
        this.gpuType = gpuType;
        this.gpuSeries = gpuSeries;
    }

    public int getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(int clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    public GPUType getGpuType() {
        return gpuType;
    }

    public void setGpuType(GPUType gpuType) {
        this.gpuType = gpuType;
    }

    public GPUSeries getGpuSeries() {
        return gpuSeries;
    }

    public void setGpuSeries(GPUSeries gpuSeries) {
        this.gpuSeries = gpuSeries;
    }

}
