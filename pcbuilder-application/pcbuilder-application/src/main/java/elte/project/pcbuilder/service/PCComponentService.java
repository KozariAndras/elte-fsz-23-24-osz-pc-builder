package elte.project.pcbuilder.service;

import elte.project.pcbuilder.domain.DTOs.FilterDTO;
import elte.project.pcbuilder.domain.DTOs.UserDto;
import elte.project.pcbuilder.domain.components.*;
import elte.project.pcbuilder.exception.InvalidPathException;
import elte.project.pcbuilder.repository.PCComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        List<PCComponent> pcComponents = pcComponentRepository.findAll();
        if(!filter.getBrands().isEmpty()){
            pcComponents = filterForBrands(filter, pcComponents);
        }
        if(isMinAndMaxNotNull(filter)){
            pcComponents = filterForPrice(filter, pcComponents);
        }
        return pcComponents;
    }

    private List<PCComponent> filterForPrice(FilterDTO filter, List<PCComponent> pcComponents) {
        BigDecimal min = filter.getMin();
        BigDecimal max = filter.getMax();

        return pcComponents.stream().filter(pcComponent ->
                pcComponent.getPrice().compareTo(min) >= 0 && pcComponent.getPrice().compareTo(max) <= 0).collect(Collectors.toList());
    }

    private List<PCComponent> filterForBrands(FilterDTO filter, List<PCComponent> pcComponents) {
        return pcComponents.stream().filter(pcComponent ->
                        filter.getBrands().contains(pcComponent.getBrand()))
                .collect(Collectors.toList());
    }

    private boolean isMinAndMaxNotNull(FilterDTO filter) {
        return filter.getMax() != null && filter.getMin() != null;
    }
}
