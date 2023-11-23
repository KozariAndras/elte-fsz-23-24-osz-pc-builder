package elte.project.pcbuilder.domain.components;

import elte.project.pcbuilder.domain.enums.CPUSocket;
import elte.project.pcbuilder.domain.enums.CPUType;
import jakarta.persistence.*;

import java.math.BigDecimal;

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
}
