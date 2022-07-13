package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArtifactsController {
    @GetMapping("/convert")
    public String showFormConvert() {
        return "converter";
    }


}
