package elte.project.pcbuilder.service;

import elte.project.pcbuilder.domain.DTOs.FilterDTO;
import elte.project.pcbuilder.domain.components.*;
import elte.project.pcbuilder.exception.InvalidPathException;
import elte.project.pcbuilder.repository.PCComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PCComponentService {
    @Autowired
    PCComponentRepository pcComponentRepository;

    public <T extends PCComponent> List<T> findPCComponentByClass(Class<T> type){
        return pcComponentRepository.findPCComponent(type);
    }

    public Iterable<PCComponent> findAll(){
        return pcComponentRepository.findAll();
    }

    public List<PCComponent> findByName(String name){
        return pcComponentRepository.findByNameContainingIgnoreCase(name);
    }

    public PCComponent findById(int id){
        return pcComponentRepository.findById(id).orElseThrow(() -> new InvalidPathException("The item was not found"));
    }

    public List<String> findDistinctBrands(){
        return pcComponentRepository.findDistinctBrands();
    }


    public List<PCComponent> findWithFilter(FilterDTO filter) {
        List<PCComponent> pcComponents = new ArrayList<>();
        pcComponentRepository.findAll().forEach(pcComponent -> {
            if(filter.getBrands().contains(pcComponent.getBrand())){
                pcComponents.add(pcComponent);
            }
        });

        return pcComponents;
    }
}
