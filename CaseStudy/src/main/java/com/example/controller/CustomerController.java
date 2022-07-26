package com.example.controller;

import com.example.model.customer.Customer;
import com.example.model.customer.CustomerType;
import com.example.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public String showCustomerList(@PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<Customer> customerList = customerService.findAllCustomer(pageable);
        List<CustomerType> customerTypeList = customerService.findAllCustomerType();
        model.addAttribute("customerList", customerList);
        model.addAttribute("customerTypeList", customerTypeList);
        return "customer/list";
    }


    @GetMapping("/search")
    public String search(@PageableDefault(value = 5) Pageable pageable, String keyword, Model model) {
        Page<Customer> customerList = customerService.findAllCustomerByKeyword(keyword, pageable);
        List<CustomerType> customerTypeList = customerService.findAllCustomerType();

        model.addAttribute("customerList", customerList);
        model.addAttribute("customerTypeList", customerTypeList);

        return "customer/list";
    }

    @GetMapping("create")
    public String showCreate(Model model) {
        List<CustomerType> customerTypeList = customerService.findAllCustomerType();
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","Thêm m?i thành công");
        return "redirect:/customer";
    }

    @GetMapping("edit/{id}")
    public String showEdit(@PathVariable int id, Model model){
        List<CustomerType> customerTypeList = customerService.findAllCustomerType();
        model.addAttribute("customerTypeList",customerTypeList);
        model.addAttribute("customer",customerService.findCustomerById(id));
        return "/customer/edit";
    }

    @PostMapping("edit")
    public String update(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "C?p nh?t thành công!");
        return "redirect:/customer";
    }

    @GetMapping("delete")
    public String delete(@RequestParam int id) {
        customerService.deleteCustomerById(id);
        return "redirect:/customer";
    }
}
