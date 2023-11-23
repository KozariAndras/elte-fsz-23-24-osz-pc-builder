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

    List<PCCase> findAllCase(){
        return pcComponentRepository.findAllCase();
    }

    public List<CPU> findAllCPU(){
        return pcComponentRepository.findAllCPU();
    }

    List<CPUCooler> findAllCPUCooler(){
        return pcComponentRepository.findAllCPUCooler();
    }

    List<GPU> findAllGPU(){
        return pcComponentRepository.findAllGPU();
    }

    List<Motherboard> findAllMotherboard(){
        return pcComponentRepository.findAllMotherboard();
    }

    List<PSU> findAllPSU(){
        return pcComponentRepository.findAllPSU();
    }

    List<RAM> findAllRAM(){
        return pcComponentRepository.findAllRAM();
    }

    List<Storage> findAllStorage(){
        return pcComponentRepository.findAllStorage();
    }


    public List<String> getAllCategories(){
        List<String> categories = new ArrayList<>();


        return categories;
    }


}
