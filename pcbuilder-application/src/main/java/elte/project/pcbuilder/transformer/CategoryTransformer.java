package elte.project.pcbuilder.transformer;

import elte.project.pcbuilder.domain.components.*;
import org.springframework.stereotype.Component;

@Component
public class CategoryTransformer {
    public Class<? extends PCComponent> transform(String category){
        return switch (category) {
            case "CPU" -> CPU.class;
            case "GPU" -> GPU.class;
            case "CPUCooler" -> CPUCooler.class;
            case "Motherboard" -> Motherboard.class;
            case "PCCase" -> PCCase.class;
            case "PSU" -> PSU.class;
            case "RAM" -> RAM.class;
            case "Storage" -> Storage.class;
            default -> PCComponent.class;
        };
    }
}
