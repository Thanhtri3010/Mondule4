package com.example.controller;

import com.example.dto.EmployeeDto;
import com.example.model.employee.Division;
import com.example.model.employee.EducationDegree;
import com.example.model.employee.Employee;
import com.example.model.employee.Position;
import com.example.service.employee.IEmployeeService;
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
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("")
    public String showEmployeeList(@PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<Employee> employeeList = employeeService.findAllEmployee(pageable);
        List<Position> positionList = employeeService.findAllPosition();
        List<EducationDegree> educationDegreeList = employeeService.findAllEducationDegree();
        List<Division> divisionList = employeeService.findAllDivision();
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("positionList", positionList);
        model.addAttribute("educationDegreeList", educationDegreeList);
        model.addAttribute("divisionList", divisionList);
        return "employee/list";
    }


    @GetMapping("/search")
    public String search(@PageableDefault(value = 5) Pageable pageable, String keyword, Model model) {
        Page<Employee> employeeList = employeeService.findAllEmployee(pageable);
        List<Position> positionList = employeeService.findAllPosition();
        List<EducationDegree> educationDegreeList = employeeService.findAllEducationDegree();
        List<Division> divisionList = employeeService.findAllDivision();
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("positionList", positionList);
        model.addAttribute("educationDegreeList", educationDegreeList);
        model.addAttribute("divisionList", divisionList);
        return "employee/list";
    }

    @GetMapping("create")
    public String showCreate(Model model) {
        List<Position> positionList = employeeService.findAllPosition();
        List<EducationDegree> educationDegreeList = employeeService.findAllEducationDegree();
        List<Division> divisionList = employeeService.findAllDivision();
        model.addAttribute("positionList", positionList);
        model.addAttribute("educationDegreeList", educationDegreeList);
        model.addAttribute("divisionList", divisionList);
        model.addAttribute("employeeDto", new EmployeeDto());
        return "employee/create";
    }

    @PostMapping("create")
    public String create(@Validated @ModelAttribute("employeeDto") EmployeeDto employeeDto, BindingResult bindingResult, RedirectAttributes redirectAttributes ,Model model){
        if (bindingResult.hasFieldErrors()){
            List<Position> positionList = employeeService.findAllPosition();
            List<EducationDegree> educationDegreeList = employeeService.findAllEducationDegree();
            List<Division> divisionList = employeeService.findAllDivision();
            model.addAttribute("positionList", positionList);
            model.addAttribute("educationDegreeList", educationDegreeList);
            model.addAttribute("divisionList", divisionList);
            return "employee/create";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("message","Thêm mới thành công");
        return "redirect:/employee";
    }

    @GetMapping("edit/{id}")
    public String showEdit(@PathVariable int id, Model model){
        List<Position> positionList = employeeService.findAllPosition();
        List<EducationDegree> educationDegreeList = employeeService.findAllEducationDegree();
        List<Division> divisionList = employeeService.findAllDivision();
        model.addAttribute("positionList", positionList);
        model.addAttribute("educationDegreeList", educationDegreeList);
        model.addAttribute("divisionList", divisionList);
        model.addAttribute("employeeDto",employeeService.findEmployeeById(id));
        return "/employee/edit";
    }

    @PostMapping("edit")
    public String update(@Validated @ModelAttribute("employeeDto") EmployeeDto employeeDto,BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model) {
        if (bindingResult.hasFieldErrors()){
            List<Position> positionList = employeeService.findAllPosition();
            List<EducationDegree> educationDegreeList = employeeService.findAllEducationDegree();
            List<Division> divisionList = employeeService.findAllDivision();
            model.addAttribute("positionList", positionList);
            model.addAttribute("educationDegreeList", educationDegreeList);
            model.addAttribute("divisionList", divisionList);
            return "/employee/edit";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "Cập nhật thành công!");
        return "redirect:/employee";
    }

    @GetMapping("delete")
    public String delete(@RequestParam int id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/employee";
    }
}
