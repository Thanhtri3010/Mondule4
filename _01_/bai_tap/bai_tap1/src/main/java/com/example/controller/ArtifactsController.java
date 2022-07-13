package com.example.controller;

import com.example.service.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ArtifactsController {
    @Autowired
    private ICurrencyService iCurrencyService;

    @GetMapping
    public String showFormConverter() {
        return "converter";
    }

    @PostMapping
    public String exchange(@RequestParam double usd, @RequestParam double rate, Model model) {
        double vnd = this.iCurrencyService.exchange(usd, rate);
        model.addAttribute("vnd", vnd);
        return "converter";
    }
}
