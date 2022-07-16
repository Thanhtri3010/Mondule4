package com.example.controller;

import com.example.modle.Person;
import com.example.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class PerSonController {
    @Autowired
    private IPersonService personService;

    @GetMapping("/list")
    public String getList(Model model) {
        List<Person> personList = personService.findAll();
        model.addAttribute("personList", personList);
        return "list";
    }

    @GetMapping(value = "/create")
    public ModelAndView getFormCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("person",new Person());
        modelAndView.addObject("yearOfBrith",personService.getYearOfBirth());
        modelAndView.addObject("gender",personService.getGender());
        modelAndView.addObject("nationality",personService.getNationality());
        modelAndView.addObject("travelInformation",personService.getTravelInformation());
        modelAndView.addObject("startDay",personService.getDay());
        modelAndView.addObject("startMonth",personService.getMonth());
        modelAndView.addObject("startYear",personService.getYear());
        modelAndView.addObject("endDay",personService.getDay());
        modelAndView.addObject("endMonth",personService.getMonth());
        modelAndView.addObject("endYear",personService.getYear());
        modelAndView.addObject("province",personService.getProvince());
        modelAndView.addObject("district",personService.getDistrict());
        modelAndView.addObject("wards",personService.getWards());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("person") Person person, RedirectAttributes redirectAttributes) {
        personService.save(person);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/display";
    }
}
