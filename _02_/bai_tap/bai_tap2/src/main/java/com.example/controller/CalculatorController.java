package com.example.controller;

import com.example.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    private ICalculatorService iCalculatorService;

    @GetMapping("")
    public String display() {
        return "index";
    }

    @GetMapping("calculate")
    public String calculate(@RequestParam int number1, @RequestParam int number2,
                            @RequestParam String operator, Model model) {
        String result = this.iCalculatorService.check(number1, number2, operator);
        model.addAttribute("result", result);
        return "index";
    }
}
