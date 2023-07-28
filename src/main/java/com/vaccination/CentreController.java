package com.vaccination;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class CentreController {
	
	@Autowired
	private CentreService centreservice;
	
	
	@GetMapping("/centre")
	public String viewHomePage(Model model) {
	    List<VaccinationCentre> vaccinationCentres = centreservice.getAllVaccinationCentre();
	    int totalCount = vaccinationCentres.size();
	    model.addAttribute("listVaccinationCentre", vaccinationCentres);
	    model.addAttribute("totalCount", totalCount);
	    return "centre";
	}

	@GetMapping("/viewCentreDetails")
	public String viewCentreDetails(Model model)
	{
		List<VaccinationCentre> vaccinationCentres = centreservice.getAllVaccinationCentre();
	    int totalCount = vaccinationCentres.size();
	    model.addAttribute("listVaccinationCentre", vaccinationCentres);
	    model.addAttribute("totalCount", totalCount);
	    return "centre";	}
	
	@GetMapping("/showNewCenterForm")
	public String showNewCenterForm(Model model)
	{
		VaccinationCentre vaccinationcentre=new  VaccinationCentre();
		model.addAttribute("vaccinationcentre",vaccinationcentre);
		return "new_centre";
	}
	@PostMapping("/saveCentre")
	
	public String saveCentre(@ModelAttribute("vaccinationcentre") VaccinationCentre vaccinationcentre) 
	{
		centreservice.saveVaccinationCentre(vaccinationcentre);
		return  "redirect:/centre";
	}
	
	@GetMapping("/showFormForEdit/{id}")
	public String showFormForEdit(@PathVariable(value="id") long id, Model model)
	{
		VaccinationCentre vaccinationcentre=centreservice.getVaccinationCentreById(id);
		
		model.addAttribute("vaccinationcentre", vaccinationcentre);
		return "edit_centre";
}
	
	@GetMapping("/deleteCentre/{id}")
	public String deleteCentre(@PathVariable(value="id")long id)
	{
		this.centreservice.deleteVaccinationCentreById(id);
		return "redirect:/centre";
	}
}
