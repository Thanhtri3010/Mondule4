package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.model.customer.Customer;
import com.example.model.customer.CustomerType;
import com.example.service.customer.ICustomerService;
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

        if (customerList.isEmpty()) {
            model.addAttribute("message", "Không tìm thấy kết quả phù hợp!");
            return "customer/list";
        }

        model.addAttribute("customerList", customerList);
        model.addAttribute("customerTypeList", customerTypeList);

        return "customer/list";
    }

    @GetMapping("create")
    public String showCreate(Model model) {
        List<CustomerType> customerTypeList = customerService.findAllCustomerType();
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("customerDto", new CustomerDto());
        return "customer/create";
    }

    @PostMapping("create")
    public String create(@Validated @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            List<CustomerType> customerTypeList = customerService.findAllCustomerType();
            model.addAttribute("customerTypeList", customerTypeList);
            return "customer/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/customer";
    }

    @GetMapping("edit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        List<CustomerType> customerTypeList = customerService.findAllCustomerType();
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("customerDto", customerService.findCustomerById(id));
        return "/customer/edit";
    }

    @PostMapping("edit")
    public String update(@Validated @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            List<CustomerType> customerTypeList = customerService.findAllCustomerType();
            model.addAttribute("customerTypeList", customerTypeList);
            return "/customer/edit";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Cập nhật thành công!");
        return "redirect:/customer";
    }

    @GetMapping("delete")
    public String delete(@RequestParam int id) {
        customerService.deleteCustomerById(id);
        return "redirect:/customer";
    }
}
