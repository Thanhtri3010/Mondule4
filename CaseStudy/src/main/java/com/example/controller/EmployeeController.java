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
        Page<Employee> employeeList = employeeService.findAllEmployeeByKeyword(keyword,pageable);
        List<Position> positionList = employeeService.findAllPosition();
        List<EducationDegree> educationDegreeList = employeeService.findAllEducationDegree();
        List<Division> divisionList = employeeService.findAllDivision();

        if (employeeList.isEmpty()) {
            model.addAttribute("message", "Không tìm thấy kết quả phù hợp!");
            return "employee/list";
        }
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("positionList", positionList);
        model.addAttribute("educationDegreeList", educationDegreeList);
        model.addAttribute("divisionList", divisionList);
        return "employee/list";
    }

    @PostMapping("/create")
    public String create(@RequestParam("newName") String name, @RequestParam("newBirthDay") String birthDay, @RequestParam("newIdentity") String idCard, @RequestParam("newSalary") double salary, @RequestParam("newPhone") String phone, @RequestParam("newEmail") String email, @RequestParam("newAddress") String address, @RequestParam("newPosition") Position position, @RequestParam("newEducationDegree") EducationDegree educationDegree, @RequestParam("newDivision") Division division, RedirectAttributes redirectAttributes) {
        employeeService.save(new Employee(name, birthDay, idCard, salary, phone, email, address, position, educationDegree, division));
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công!");
        return "redirect:/employee";
    }

//    @PostMapping("/update")
//    public String update(@RequestParam("id") Integer id, @RequestParam("name") String name, @RequestParam("birthDay") String birthDay, @RequestParam("idCard") String idCard, @RequestParam("salary") Double salary, @RequestParam("phone") String phone, @RequestParam("email") String email, @RequestParam("address") String address, @RequestParam("position") Position position, @RequestParam("educationDegree") EducationDegree educationDegree, @RequestParam("division") Division division, RedirectAttributes redirectAttributes) {
//        Employee employee = employeeService.findById(id);
//        employee.setName(name);
//        employee.setBirthDay(birthDay);
//        employee.setIdCard(idCard);
//        employee.setSalary(salary);
//        employee.setPhone(phone);
//        employee.setEmail(email);
//        employee.setAddress(address);
//        employee.setPosition(position);
//        employee.setEducationDegree(educationDegree);
//        employee.setDivision(division);
//        employeeService.save(employee);
//        redirectAttributes.addFlashAttribute("message", "Cập nhật thành công!");
//        return "redirect:/employee";
//    }


    @GetMapping("delete")
    public String delete(@RequestParam int id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/employee";
    }
}
