package domain.classes;

import domain.enums.CPUSocket;
import jakarta.persistence.Entity;

public abstract class CPU extends PCComponent {

    private int cores;
    private int threads;
    private int coreSpeed;
    private int maxCoreSpeed;

    private CPUSocket cpuSocket;


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
}
