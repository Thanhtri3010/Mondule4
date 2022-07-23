package com.example.controller;

import com.example.dto.SongDto;
import com.example.model.Song;
import com.example.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String show(Model model){
        List<Song> songList = songService.findAll();
        model.addAttribute("songList",songList);
        return "list";
    }
    @GetMapping("create")
    public String showCreate(Model model){
        model.addAttribute("songDto",new SongDto());
        return "create";
    }
    @PostMapping("create")
    public String create(@ModelAttribute @Validated SongDto songDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes){
        if (bindingResult.hasFieldErrors()){
            return "create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        redirectAttributes.addFlashAttribute("message", "Add song successful");
        songService.save(song);
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    public String showEdit(@PathVariable int id, Model model){
        model.addAttribute("songDto",songService.findById(id));
        return "edit";
    }
    @PostMapping("edit")
    public String edit(@ModelAttribute @Validated SongDto songDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "edit";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        redirectAttributes.addFlashAttribute("message", "Update song successful");
        songService.save(song);
        return "redirect:/";
    }
}
