package elte.project.pcbuilder.convertor;

import elte.project.pcbuilder.domain.components.*;
import org.springframework.core.convert.converter.Converter;

public class StringToComponentClass implements Converter<String, Class<? extends PCComponent>> {
    @Override
    public Class<? extends PCComponent> convert(String source) {
        switch (source){
            case "CPU" -> {
                return CPU.class;
            }
            case "CPUCooler" -> {
                return CPUCooler.class;
            }
            case "GPU" -> {
                return GPU.class;
            }
            case "Motherboard" -> {
                return Motherboard.class;
            }
            case "PCCase" -> {
                return PCCase.class;
            }
            case "PSU" -> {
                return PSU.class;
            }
            case "RAM" -> {
                return RAM.class;
            }
            case "Storage" -> {
                return Storage.class;
            }
            default -> {
                return PCComponent.class;
            }

        }

    }
}
