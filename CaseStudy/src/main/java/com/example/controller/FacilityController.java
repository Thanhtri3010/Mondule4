package com.example.controller;


import com.example.dto.CustomerDto;
import com.example.dto.FacilityDto;
import com.example.model.customer.Customer;
import com.example.model.customer.CustomerType;
import com.example.model.facility.Facility;
import com.example.model.facility.FacilityType;
import com.example.model.facility.RentType;
import com.example.service.customer.ICustomerService;
import com.example.service.facility.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("facility")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;

    @GetMapping("")
    public String showFacilityList(@PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<Facility> facilityList = facilityService.findAllFacility(pageable);
        List<FacilityType> facilityTypeList = facilityService.findAllFacilityType();
        List<RentType> rentTypeList = facilityService.findAllRentType();
        model.addAttribute("facilityList", facilityList);
        model.addAttribute("facilityTypeList", facilityTypeList);
        model.addAttribute("rentTypeList", rentTypeList);
        return "facility/list";
    }


    @GetMapping("/search")
    public String search(@PageableDefault(value = 5) Pageable pageable, String keyword, Model model) {
        Page<Facility> facilityList = facilityService.findAllFacilityByKeyword(keyword, pageable);
        List<FacilityType> facilityTypeList = facilityService.findAllFacilityType();
        List<RentType> rentTypeList = facilityService.findAllRentType();

        model.addAttribute("facilityList", facilityList);
        model.addAttribute("facilityTypeList", facilityTypeList);
        model.addAttribute("rentTypeList", rentTypeList);

        return "facility/list";
    }

    @GetMapping("create")
    public String showFacility(Model model) {
        List<FacilityType> facilityTypeList = facilityService.findAllFacilityType();
        List<RentType> rentTypeList = facilityService.findAllRentType();

        model.addAttribute("facilityTypeList", facilityTypeList);
        model.addAttribute("rentTypeList", rentTypeList);
        model.addAttribute("facilityDto", new FacilityDto());
        return "facility/create";
    }

    @PostMapping("create")
    public String create(@Validated @ModelAttribute("facilityDto") FacilityDto facilityDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if (bindingResult.hasFieldErrors()){
            List<FacilityType> facilityTypeList = facilityService.findAllFacilityType();
            List<RentType> rentTypeList = facilityService.findAllRentType();

            model.addAttribute("facilityTypeList", facilityTypeList);
            model.addAttribute("rentTypeList", rentTypeList);
            return "facility/create";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto,facility);
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("message","Thêm mới thành công");
        return "redirect:/facility";
    }

    @GetMapping("edit/{id}")
    public String showEdit(@PathVariable int id, Model model){
        List<FacilityType> facilityTypeList = facilityService.findAllFacilityType();
        List<RentType> rentTypeList = facilityService.findAllRentType();
        model.addAttribute("facilityTypeList",facilityTypeList);
        model.addAttribute("rentTypeList", rentTypeList);

        model.addAttribute("facilityDto",facilityService.findFacilityById(id));
        return "/facility/edit";
    }

    @PostMapping("edit")
    public String update(@Validated @ModelAttribute("facilityDto") FacilityDto facilityDto,BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model) {
        if (bindingResult.hasFieldErrors()){
            List<FacilityType> facilityTypeList = facilityService.findAllFacilityType();
            List<RentType> rentTypeList = facilityService.findAllRentType();
            model.addAttribute("facilityTypeList",facilityTypeList);
            model.addAttribute("rentTypeList", rentTypeList);
            return "/facility/edit";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto,facility);
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("message", "Cập nhật thành công!");
        return "redirect:/facility";
    }

    @GetMapping("delete")
    public String delete(@RequestParam int id) {
        facilityService.deleteFacilityById(id);
        return "redirect:/facility";
    }
}

