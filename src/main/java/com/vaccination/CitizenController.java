package com.vaccination;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CitizenController {
    
    @Autowired
    private CitizenService citizenservice;

    // Display list of citizens
    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Citizen> citizens = citizenservice.getAllCitizen();
        int totalCount = citizens.size();
        model.addAttribute("ListCitizen", citizens);
        model.addAttribute("totalCount", totalCount);
        return "index";
    }


    @GetMapping("/showNewCitizenForm")
    public String showNewCitizenForm(Model model) {
        Citizen citizen = new Citizen();
        model.addAttribute("citizen", citizen);
        return "new_citizen";
    }

    @PostMapping("/saveCitizen")
    public String saveCitizen(@ModelAttribute("citizen") Citizen citizen) {
        citizenservice.saveCitizen(citizen);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Citizen citizen = citizenservice.getCitizenById(id);
        model.addAttribute("citizen", citizen);
    
        return "update_citizen";
}
    
    @GetMapping("/deleteCitizen/{id}")
    public String deleteCitizen(@PathVariable(value="id") long id)
    {
    	//delete the citizen
    	this.citizenservice.deleteCitizenById(id);
    	return "redirect:/";
    }
    
    
    
    //new
    
}
