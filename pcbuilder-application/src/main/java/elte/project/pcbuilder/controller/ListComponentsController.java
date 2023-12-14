package elte.project.pcbuilder.controller;

import elte.project.pcbuilder.domain.components.CPU;
import elte.project.pcbuilder.domain.components.PCComponent;
import elte.project.pcbuilder.service.PCComponentService;
import elte.project.pcbuilder.transformer.CategoryTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ListComponentsController {
    @Autowired
    private PCComponentService pcComponentService;
    @Autowired
    private CategoryTransformer categoryTransformer;

    @GetMapping("/")
    public String listComponents(Model model){
        List<PCComponent> allComponents = new ArrayList<>();
        pcComponentService.findAll().forEach(allComponents::add);

        model.addAttribute("components",allComponents);

        return "components";
    }

    @GetMapping("/{category}")
    public String listComponentsBasedOnCategory(Model model,@PathVariable("category") String category){
        List<? extends PCComponent> components = pcComponentService.findPCComponentByClass(categoryTransformer.transform(category));
        model.addAttribute("components",components);
        return "components";

    }
}
