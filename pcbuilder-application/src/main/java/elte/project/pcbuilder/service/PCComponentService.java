package elte.project.pcbuilder.service;

import elte.project.pcbuilder.domain.components.*;
import elte.project.pcbuilder.repository.PCComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PCComponentService {
    @Autowired
    PCComponentRepository pcComponentRepository;

    public List<PCComponent> findAllById(int id){
        return pcComponentRepository.findAllById(id);
    }
    public List<PCComponent> findAllByBrand(String brand){
        return pcComponentRepository.findAllByBrand(brand);
    }
    public List<PCComponent> findAllByName(String name){
        return pcComponentRepository.findAllByName(name);
    }
    List<PCComponent> findAllByPriceIsLessThanEqual(BigDecimal price){
        return pcComponentRepository.findAllByPriceIsGreaterThanEqual(price);
    }
    List<PCComponent> findAllByPriceIsGreaterThanEqual(BigDecimal price){
        return pcComponentRepository.findAllByPriceIsGreaterThanEqual(price);
    }

    public List<PCCase> findAllCase(){
        return pcComponentRepository.findAllCase();
    }

    public List<CPU> findAllCPU(){
        return pcComponentRepository.findAllCPU();
    }

    public List<CPUCooler> findAllCPUCooler(){
        return pcComponentRepository.findAllCPUCooler();
    }

    public List<GPU> findAllGPU(){
        return pcComponentRepository.findAllGPU();
    }

    public List<Motherboard> findAllMotherboard(){
        return pcComponentRepository.findAllMotherboard();
    }

    public List<PSU> findAllPSU(){
        return pcComponentRepository.findAllPSU();
    }

    public List<RAM> findAllRAM(){
        return pcComponentRepository.findAllRAM();
    }

    public List<Storage> findAllStorage(){
        return pcComponentRepository.findAllStorage();
    }



}
