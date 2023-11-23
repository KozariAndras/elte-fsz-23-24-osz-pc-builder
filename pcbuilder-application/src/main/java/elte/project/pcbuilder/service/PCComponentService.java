package elte.project.pcbuilder.service;

import elte.project.pcbuilder.repository.PCComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PCComponentService {
    @Autowired
    PCComponentRepository pcComponentRepository;

    public List<String> getAllCategories(){
        List<String> categories = new ArrayList<>();


        return categories;
    }
}
