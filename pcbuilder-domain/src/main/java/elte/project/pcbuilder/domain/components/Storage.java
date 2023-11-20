package elte.project.pcbuilder.domain.components;

import elte.project.pcbuilder.domain.enums.StorageType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Storage extends PCComponent {

    private int size;
    private int writingSpeed;
    private int readingSpeed;
    @Enumerated(EnumType.STRING)
    private StorageType storageType;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getWritingSpeed() {
        return writingSpeed;
    }

    public void setWritingSpeed(int writingSpeed) {
        this.writingSpeed = writingSpeed;
    }

    public int getReadingSpeed() {
        return readingSpeed;
    }

    public void setReadingSpeed(int readingSpeed) {
        this.readingSpeed = readingSpeed;
    }

    public StorageType getStorageType() {
        return storageType;
    }

    public void setStorageType(StorageType storageType) {
        this.storageType = storageType;
    }
}
