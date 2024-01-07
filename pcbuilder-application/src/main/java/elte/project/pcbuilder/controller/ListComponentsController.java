package elte.project.pcbuilder.controller;

import elte.project.pcbuilder.domain.DTOs.FilterDTO;
import elte.project.pcbuilder.domain.components.PCComponent;
import elte.project.pcbuilder.domain.user.Cart;
import elte.project.pcbuilder.service.PCComponentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ListComponentsController {
    @Autowired
    private PCComponentService pcComponentService;

    @ModelAttribute("brands")
    public List<String> getBrands() {
        return pcComponentService.findDistinctBrands();
    }

    @GetMapping("/")
    public String listComponents(Model model){
        List<PCComponent> allComponents = new ArrayList<>();
        pcComponentService.findAll().forEach(allComponents::add);
        model.addAttribute("components",allComponents);
        return "components";
    }

    @GetMapping("/{category}")
    public String listComponentsBasedOnCategory(Model model,@PathVariable("category") Class<? extends PCComponent> category){
        List<? extends PCComponent> components = pcComponentService.findPCComponentByClass(category);
        model.addAttribute("components",components);
        return "components";

    }

    @GetMapping("/search")
    public String search(@RequestParam("search") String search,Model model){
        List<PCComponent> pcComponents = pcComponentService.findByName(search);
        model.addAttribute("components",pcComponents);
        return "components";
    }

    @PostMapping("/searchFilter")
    public String search(@Valid @ModelAttribute("filter")FilterDTO filter, BindingResult result, Model model){
        if(result.hasErrors()){
            return "redirect:/";
        } else {
            List<PCComponent> pcComponents = pcComponentService.findWithFilter(filter);
            model.addAttribute("components",pcComponents);
            return "components";
        }

    }
}
