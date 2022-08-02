package com.example.blogs.controller;

import com.example.blogs.model.Blog;
import com.example.blogs.model.Category;
import com.example.blogs.service.IBlogService;
import com.example.blogs.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String showBlog(@RequestParam("keySearch") Optional<String> keySearch, @PageableDefault(value = 5) Pageable pageable, Model model) {
        List<Category> categoryList = categoryService.findAll();
        Page<Blog> blogList;

        if (keySearch.isPresent()) {
            blogList = blogService.findAllByNameContaining(keySearch.get(), pageable);
        } else {
            blogList = blogService.findAll(pageable);
        }

        model.addAttribute("blogList", blogList);
        model.addAttribute("categoryList", categoryList);
        return "list";
    }

    @GetMapping("/sort")
    public String sortBlog(@PageableDefault(value = 5, sort = "dateCreate", direction = Sort.Direction.ASC) Pageable pageable, Model model) {
        List<Category> categoryList = categoryService.findAll();
        Page<Blog> blogList = blogService.findAll(pageable);

        model.addAttribute("blogList", blogList);
        model.addAttribute("categoryList", categoryList);
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("category",categoryService.findAll());
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("category",categoryService.findById(id));
        model.addAttribute("blog", blogService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        blogService.remove(id);
        return "redirect:/blog";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "view";
    }
}
