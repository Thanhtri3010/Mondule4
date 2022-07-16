package com.example.controller;

import com.example.modle.Email;
import com.example.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmailController {
    @Autowired
    private IEmailService emailService;

    @GetMapping("/display")
    public ModelAndView showDisplay() {
        ModelAndView modelAndView = new ModelAndView("display");
        List<Email> emailList  = emailService.findAll();
        modelAndView.addObject("emailList",emailList);
        return modelAndView;
    }

    @GetMapping("/update")
    public ModelAndView showUpdate(@RequestParam Integer id){
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("email",emailService.findByID(id));
        modelAndView.addObject("languageArr",emailService.showLanguages());
        modelAndView.addObject("pageSizeArr",emailService.showPageSize());
        return modelAndView;
    }

    @PostMapping("/update")
    public String updateEmail(@ModelAttribute("email") Email email) {
        emailService.save(email.getId(), email);
        return "redirect:/display";
    }
}
