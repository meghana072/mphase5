package com.vaccination;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {
    private AdminService adminService;
    @Autowired
    private CitizenService citizenService;
    @Autowired
    private CentreService centreservice;
    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admin/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginAdmin(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             Model model) {
        if (adminService.loginAdmin(username, password)) {
            model.addAttribute("username", username);
            return "welcome";
        }
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerAdmin(@RequestParam("username") String username,
                                @RequestParam("password") String password,
                                Model model) {
        Admin admin = adminService.registerAdmin(username, password);
        model.addAttribute("username", admin.getUsername());
        return "redirect:/admin/login";
    }

    @GetMapping("/logout")
    public String logoutAdmin(Model model) {
        // Perform logout actions
    	model.addAttribute("message", "You have successfully logged out");
        return "login";
    }
    @GetMapping("/citizen")
    public String showCitizenPage(Model model) {
        List<Citizen> citizens = citizenService.getAllCitizen();
        model.addAttribute("citizens", citizens);
        return "redirect:/";
    }
    @GetMapping("/vaccination-center")
    public String showVaccinationCentrepage(Model model) {
        List<VaccinationCentre> vaccinationCentres = centreservice.getAllVaccinationCentre();
        model.addAttribute("listVaccinationCentre", vaccinationCentres);
        return "centre"; // Return the view name for centre.html
    }
    // Add other controller methods for citizen, vaccination center, etc.
}


