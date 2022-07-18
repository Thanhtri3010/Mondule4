package com.example.controller;

import com.example.model.MedicalDeclaration;
import com.example.service.IMedicalDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MedicalDeclarationController {
    @Autowired
    private IMedicalDeclarationService medicalDeclarationService;

    @GetMapping("/list")
    public String getList(Model model) {
        List<MedicalDeclaration> medicalDeclarationList = medicalDeclarationService.findAll();
        model.addAttribute("medicalDeclarationList", medicalDeclarationList);
        return "list";
    }

    @GetMapping(value = "/create")
    public ModelAndView getFormCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("medicalDeclaration",new MedicalDeclaration());
        modelAndView.addObject("yearOfBirth", medicalDeclarationService.getYearOfBirth());
        modelAndView.addObject("travelInformation", medicalDeclarationService.getTravelInformation());
        modelAndView.addObject("startDay", medicalDeclarationService.getDay());
        modelAndView.addObject("endDay", medicalDeclarationService.getDay());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("person") MedicalDeclaration medicalDeclaration, RedirectAttributes redirectAttributes) {
        medicalDeclarationService.save(medicalDeclaration);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/list";
    }

    @GetMapping("/update")
    public ModelAndView showUpdatePage(@RequestParam Integer id) {
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("medicalDeclaration", new MedicalDeclaration());

        modelAndView.addObject("yearOfBirth", medicalDeclarationService.getYearOfBirth());

        modelAndView.addObject("travelInformation",medicalDeclarationService.getTravelInformation());

        modelAndView.addObject("starDay", medicalDeclarationService.getDay());

        modelAndView.addObject("endDay", medicalDeclarationService.getDay());

        modelAndView.addObject("medicalDeclaration",medicalDeclarationService.findByID(id));
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("medicalDeclaration") MedicalDeclaration medicalDeclaration, RedirectAttributes redirectAttributes) {
        medicalDeclarationService.update(medicalDeclaration.getId(), medicalDeclaration);
        redirectAttributes.addFlashAttribute("message", "Cập nhật thành công");
        return "redirect:/list";
    }

}
