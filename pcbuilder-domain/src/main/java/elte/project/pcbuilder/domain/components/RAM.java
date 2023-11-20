package elte.project.pcbuilder.domain.components;

import elte.project.pcbuilder.domain.components.PCComponent;
import elte.project.pcbuilder.domain.enums.RamSocketType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class RAM extends PCComponent {

    private String timings;
    private int speed;
    private int size;
    @Enumerated(EnumType.STRING)
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
