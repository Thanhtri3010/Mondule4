package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public String show(@PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<Product> productList = productService.findAll(pageable);
        model.addAttribute("productList", productList);
        return "list";
    }

    @GetMapping("create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create", "product", new Product());
        return modelAndView;
    }

    @PostMapping("create")
    public String create(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @PostMapping("edit")
    public String edit(@ModelAttribute("product") Product product) {
        productService.save(product);
        return "redirect:";
    }

    @GetMapping("delete")
    public String delete(@RequestParam int id) {
        productService.remove(id);
        return "redirect:";
    }

    @PostMapping("/search")
    public String search(@RequestParam String name, Model model) {
        List<Product> products = productService.searchProduct(name);
        model.addAttribute("productList", products);
        return "list";
    }
}
