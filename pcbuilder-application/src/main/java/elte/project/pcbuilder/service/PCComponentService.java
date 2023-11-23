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

    List<PCComponent> findAllById(int id){
        return pcComponentRepository.findAllById(id);
    }
    List<PCComponent> findAllByBrand(String brand){
        return pcComponentRepository.findAllByBrand(brand);
    }
    List<PCComponent> findAllByName(String name){
        return pcComponentRepository.findAllByName(name);
    }
    List<PCComponent> findAllByPriceIsLessThanEqual(BigDecimal price){
        return pcComponentRepository.findAllByPriceIsGreaterThanEqual(price);
    }
    List<PCComponent> findAllByPriceIsGreaterThanEqual(BigDecimal price){
        return pcComponentRepository.findAllByPriceIsGreaterThanEqual(price);
    }

    List<Case> findAllCase(){
        List<Case> cases = new ArrayList<Case>();

        for (PCComponent component : pcComponentRepository.findAll()) {
            if (component instanceof Case){
                cases.add((Case) component);
            }
        }
        return cases;
    }

    List<CPU> findAllCPU(){
        List<CPU> cpus = new ArrayList<CPU>();

        for (PCComponent component : pcComponentRepository.findAll()) {
            if (component instanceof CPU){
                cpus.add((CPU) component);
            }
        }
        return cpus;
    }

    List<CPUCooler> findAllCPUCooler(){
        List<CPUCooler> cpuCoolers = new ArrayList<CPUCooler>();

        for (PCComponent component : pcComponentRepository.findAll()) {
            if (component instanceof CPUCooler){
                cpuCoolers.add((CPUCooler) component);
            }
        }
        return cpuCoolers;
    }

    List<GPU> findAllGPU(){
        List<GPU> gpus = new ArrayList<GPU>();

        for (PCComponent component : pcComponentRepository.findAll()) {
            if (component instanceof GPU){
                gpus.add((GPU) component);
            }
        }
        return gpus;
    }

    List<Motherboard> findAllMotherboard(){
        List<Motherboard> motherboards = new ArrayList<Motherboard>();

        for (PCComponent component : pcComponentRepository.findAll()) {
            if (component instanceof Motherboard){
                motherboards.add((Motherboard) component);
            }
        }
        return motherboards;
    }

    List<PSU> findAllPSU(){
        List<PSU> psus = new ArrayList<PSU>();

        for (PCComponent component : pcComponentRepository.findAll()) {
            if (component instanceof PSU){
                psus.add((PSU) component);
            }
        }
        return psus;
    }

    List<RAM> findAllRAM(){
        List<RAM> rams = new ArrayList<RAM>();

        for (PCComponent component : pcComponentRepository.findAll()) {
            if (component instanceof RAM){
                rams.add((RAM) component);
            }
        }
        return rams;
    }

    List<Storage> findAllStorage(){
        List<Storage> storages = new ArrayList<Storage>();

        for (PCComponent component : pcComponentRepository.findAll()) {
            if (component instanceof Storage){
                storages.add((Storage) component);
            }
        }
        return storages;
    }


    public List<String> getAllCategories(){
        List<String> categories = new ArrayList<>();


        return categories;
    }


}
