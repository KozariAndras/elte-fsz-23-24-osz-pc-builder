package elte.project.pcbuilder.domain.classes;

import elte.project.pcbuilder.domain.enums.RamSocketType;
import jakarta.persistence.Entity;

@Entity
public class RAM extends PCComponent{

    private String timings;
    private int speed;
    private int size;
    private RamSocketType ramSocketType;



    public String getTimings() {
        return timings;
    }

    public void setTimings(String timings) {
        this.timings = timings;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public RamSocketType getRamSocketType() {
        return ramSocketType;
    }

    public void setRamSocketType(RamSocketType ramSocketType) {
        this.ramSocketType = ramSocketType;
    }
}