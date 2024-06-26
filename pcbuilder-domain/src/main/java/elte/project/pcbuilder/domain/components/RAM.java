package elte.project.pcbuilder.domain.components;

import elte.project.pcbuilder.domain.components.PCComponent;
import elte.project.pcbuilder.domain.enums.RamSocketType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class RAM extends PCComponent {

    private String timings;
    private int speed;
    private int size;
    @Enumerated(EnumType.STRING)
    private RamSocketType ramSocketType;

    public RAM() {
    }

    public RAM(String name, String brand, BigDecimal price, String timings, int speed, int size, RamSocketType ramSocketType) {
        super(name, brand, price);
        this.timings = timings;
        this.speed = speed;
        this.size = size;
        this.ramSocketType = ramSocketType;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RAM ram)) return false;
        if (!super.equals(o)) return false;
        return speed == ram.speed && size == ram.size && Objects.equals(timings, ram.timings) && ramSocketType == ram.ramSocketType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), timings, speed, size, ramSocketType);
    }
}
