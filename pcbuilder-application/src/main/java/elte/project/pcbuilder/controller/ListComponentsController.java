package elte.project.pcbuilder.controller;

import elte.project.pcbuilder.domain.components.PCComponent;
import elte.project.pcbuilder.domain.user.Cart;
import elte.project.pcbuilder.service.PCComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ListComponentsController {
    @Autowired
    private PCComponentService pcComponentService;

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
}
