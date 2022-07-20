package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.Music;
import vn.codegym.service.IMusicService;

import java.util.List;

@Controller

public class MusicController {
    @Autowired
    private IMusicService musicService;

    @GetMapping
    public String show(Model model) {
        List<Music> musicList = musicService.findAll();
        model.addAttribute("musicList", musicList);
        return "list";
    }

    @GetMapping("create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create", "music", new Music());
        return modelAndView;
    }

    @PostMapping("create")
    public String create(@ModelAttribute Music music) {
        musicService.create(music);
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("music", musicService.findById(id));
        return "edit";
    }

    @PostMapping("edit")
    public String edit(@ModelAttribute("music") Music music) {
        musicService.update(music.getId(), music);
        return "redirect:/list";
    }

    @GetMapping("/delete")
    public String displayDeletePage(@RequestParam int id) {
        musicService.remove(id);
        return "redirect:/list";
    }

}
