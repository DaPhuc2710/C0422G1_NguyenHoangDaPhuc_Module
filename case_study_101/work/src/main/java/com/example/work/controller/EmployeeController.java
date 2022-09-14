package com.example.work.controller;

import com.example.work.dto.EmployeeDto;
import com.example.work.model.employee.Employee;

import com.example.work.service.IEmployeeService;
import com.example.work.service.IPositionTypeService;
import com.example.work.service.ISectionTypeService;
import com.example.work.service.IStandardTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;


@Controller
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IPositionTypeService iPositionTypeService;
    @Autowired
    private IStandardTypeService iStandardTypeService;
    @Autowired
    private ISectionTypeService iSectionTypeService;

    @GetMapping("/goEmployeeList")
    public String goList(Model model,
                         @PageableDefault(size = 5) Pageable pageable,
                         @RequestParam Optional<String> key) {
        String keyVal = key.orElse("");
        model.addAttribute("employeeList", iEmployeeService.findAllByEmployeeNameContaining(keyVal, pageable));
        model.addAttribute("keyVal", keyVal);
        return "/employees/employees_list_page";
    }

    @GetMapping("/goDetele")
    public String goDelete(@RequestParam int deleteId, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("msg", "Xóa thành công");
        iEmployeeService.delete(deleteId);
        return "redirect:/goEmployeeList";
    }

    @GetMapping("/goAddEmployee")
    public String goAddForm(Model model) {
        model.addAttribute("employeeList", new EmployeeDto());
        model.addAttribute("positionType", iPositionTypeService.findAll());
        model.addAttribute("sectionType", iSectionTypeService.findALL());
        model.addAttribute("standardType", iStandardTypeService.findALL());
        return "/employees/employees_adding_page";
    }

    @PostMapping("/saveAddEmployee")
    public String saveAddForm(@ModelAttribute("employeeList") @Valid EmployeeDto employeeDto,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,
                              Model model) {
        employeeDto.validate(employeeDto,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("positionType", iPositionTypeService.findAll());
            model.addAttribute("sectionType", iSectionTypeService.findALL());
            model.addAttribute("standardType", iStandardTypeService.findALL());
            return "/employees/employees_adding_page";
        }
        Employee employee= new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        iEmployeeService.save(employee);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/goEmployeeList";
    }

    @GetMapping("/goDeteleEmployee")
    public String goDetele(Integer deleteId) {
        iEmployeeService.delete(deleteId);
        return "redirect:/goEmployeeList";
    }

    @GetMapping("/goUpdateEmployee")
    public String goUpdateForm(Integer id, Model model) {
        model.addAttribute("employeeList",iEmployeeService.findById(id).get());
        model.addAttribute("positionType", iPositionTypeService.findAll());
        model.addAttribute("sectionType", iSectionTypeService.findALL());
        model.addAttribute("standardType", iStandardTypeService.findALL());
        return "/employees/employees_update_page";
    }

    @PostMapping("/saveUpdateEmployee")
    public String saveUpdateForm(@ModelAttribute("employeeList") @Valid EmployeeDto employeeDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {
        employeeDto.validate(employeeDto,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("positionType", iPositionTypeService.findAll());
            model.addAttribute("sectionType", iSectionTypeService.findALL());
            model.addAttribute("standardType", iStandardTypeService.findALL());
            return "/employees/employees_update_page";
        }
        Employee employee= new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        iEmployeeService.update(employee);
        redirectAttributes.addFlashAttribute("msg", "Sửa thành công");
        return "redirect:/goEmployeeList";
    }
}
