package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Music;
import vn.codegym.service.IMusicService;

import java.util.List;

@Controller
//@RequestMapping("/music")

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
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("create", "music",new Music());
        return modelAndView;
    }
    @PostMapping("create")
    public String create(@ModelAttribute Music music){
        musicService.create(music);
        return "redirect:/list";
    }
    @GetMapping("edit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("music", musicService.findById(id));
        return "edit";
    }

    @PostMapping("update")
    public String edit(@ModelAttribute("music") Music music) {
        musicService.update(music.getId(), music);
        return "redirect:/list";
    }

    @GetMapping("/{id}/delete")
    public String displayDeletePage(@PathVariable int id, Model model) {
        Music song = musicService.findById(id);
        model.addAttribute("song", song);
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Music music, RedirectAttributes redirectAttributes) {
        musicService.remove(music.getId());
        redirectAttributes.addFlashAttribute("success", "Delete song successfully!");
        return "redirect:/list";
    }
}
