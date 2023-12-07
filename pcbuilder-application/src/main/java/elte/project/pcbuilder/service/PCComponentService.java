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

    public <T extends PCComponent> List<T> findPCComponentByClass(Class<T> type){
        return pcComponentRepository.findPCComponent(type);
    }



}
