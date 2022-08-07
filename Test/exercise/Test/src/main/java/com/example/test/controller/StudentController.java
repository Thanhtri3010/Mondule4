package com.example.test.controller;

import com.example.test.dto.StudentDto;
import com.example.test.model.ClassRoom;
import com.example.test.model.Student;
import com.example.test.service.IClassRoomService;
import com.example.test.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @Autowired
    private IClassRoomService classRoomService;

    @GetMapping("")
    public String showStudentList(@RequestParam(name = "page", defaultValue = "0") int page,
                                  @RequestParam(name = "name", defaultValue = "") String name, Model model) {
        model.addAttribute("studentList", studentService.findAllStudentByKeyword(PageRequest.of(page, 5), name));
        model.addAttribute("name", name);
        return "/list";
    }

    @GetMapping("create")
    public String showCreate(Model model) {
        List<ClassRoom> classRoomList = classRoomService.findAllClassRoom();
        model.addAttribute("classRoomList", classRoomList);
        model.addAttribute("studentDto", new StudentDto());
        return "/create";
    }

    @PostMapping("create")
    public String create(@Validated @ModelAttribute("studentDto") StudentDto studentDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            List<ClassRoom> classRoomList = classRoomService.findAllClassRoom();
            model.addAttribute("classRoomList", classRoomList);
            return "/create";
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        studentService.save(student);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/student";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        List<ClassRoom> classRoomList = classRoomService.findAllClassRoom();
        model.addAttribute("classRoomList", classRoomList);
        model.addAttribute("studentDto", studentService.findStudentById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String update(@Validated @ModelAttribute("studentDto") StudentDto studentDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            List<ClassRoom> classRoomList = classRoomService.findAllClassRoom();
            model.addAttribute("classRoomList", classRoomList);
            return "/edit";
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        studentService.save(student);
        redirectAttributes.addFlashAttribute("message", "Cập nhật thành công!");
        return "redirect:/student";
    }

    @GetMapping("delete")
    public String delete(@RequestParam int id) {
        studentService.deleteStudentById(id);
        return "redirect:/student";
    }
}

