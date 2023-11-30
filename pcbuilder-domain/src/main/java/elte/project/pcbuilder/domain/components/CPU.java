package elte.project.pcbuilder.domain.components;

import elte.project.pcbuilder.domain.enums.CPUSocket;
import elte.project.pcbuilder.domain.enums.CPUType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "CPUs")
@Inheritance(strategy = InheritanceType.JOINED)
public class CPU extends PCComponent {

    private int cores;
    private int threads;
    private int coreSpeed;
    private int maxCoreSpeed;

    @Enumerated(EnumType.STRING)
    private CPUSocket cpuSocket;

    @Enumerated(EnumType.STRING)
    private CPUType cpuType;

    public CPU() {
    }

    public CPU(String name, String brand, BigDecimal price, int cores, int threads, int coreSpeed, int maxCoreSpeed, CPUSocket cpuSocket, CPUType cpuType) {
        super(name, brand, price);
        this.cores = cores;
        this.threads = threads;
        this.coreSpeed = coreSpeed;
        this.maxCoreSpeed = maxCoreSpeed;
        this.cpuSocket = cpuSocket;
        this.cpuType = cpuType;
    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public int getThreads() {
        return threads;
    }

    public void setThreads(int threads) {
        this.threads = threads;
    }

    public int getCoreSpeed() {
        return coreSpeed;
    }

    public void setCoreSpeed(int coreSpeed) {
        this.coreSpeed = coreSpeed;
    }

    public int getMaxCoreSpeed() {
        return maxCoreSpeed;
    }

    public void setMaxCoreSpeed(int maxCoreSpeed) {
        this.maxCoreSpeed = maxCoreSpeed;
    }

    public CPUSocket getCpuSocket() {
        return cpuSocket;
    }

    public void setCpuSocket(CPUSocket cpuSocket) {
        this.cpuSocket = cpuSocket;
    }

    public CPUType getCpuType() {
        return cpuType;
    }

    public void setCpuType(CPUType cpuType) {
        this.cpuType = cpuType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CPU cpu)) return false;
        if (!super.equals(o)) return false;
        return cores == cpu.cores && threads == cpu.threads && coreSpeed == cpu.coreSpeed && maxCoreSpeed == cpu.maxCoreSpeed && cpuSocket == cpu.cpuSocket && cpuType == cpu.cpuType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cores, threads, coreSpeed, maxCoreSpeed, cpuSocket, cpuType);
    }
}
