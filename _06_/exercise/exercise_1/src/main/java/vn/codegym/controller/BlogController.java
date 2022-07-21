package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.codegym.model.Blog;
import vn.codegym.service.IBlogService;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping
    public String showBlog(Model model) {
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blogList", blogList);
        return "list";
    }
    @GetMapping("create")
    public String showCreate(Model model){
        model.addAttribute("blog",new Blog());
        return "create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute("blog") Blog blog){
        blogService.create(blog);
        return "redirect:";
    }
    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id, Model model){
        model.addAttribute("blog", blogService.findById(id));
        return "edit";
    }
    @PostMapping("edit")
    public String edit(@ModelAttribute("blog") Blog blog){
        blogService.update(blog.getId(),blog);
        return "redirect:";
    }
    @GetMapping("delete")
    public String delete(@RequestParam int id){
        blogService.remove(id);
        return "redirect:";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "view";
    }
}
