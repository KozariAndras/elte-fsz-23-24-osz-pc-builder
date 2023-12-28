package elte.project.pcbuilder.controller;

import elte.project.pcbuilder.domain.components.PCComponent;
import elte.project.pcbuilder.service.PCComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DetailsController {

    @Autowired
    private PCComponentService pcComponentService;

    @GetMapping("/details{id}")
    public String details(@PathVariable("id") int productId, Model model){
        PCComponent pcComponent = pcComponentService.findById(productId);
        model.addAttribute("type",pcComponent.getClass().getSimpleName());
        model.addAttribute("component",pcComponent);
        return "details";
    }
}
