package com.example.work.employee.controller;

import com.example.work.employee.model.Employee;
import com.example.work.employee.service.IEmployeeService;
import com.example.work.employee.service.IPositionTypeService;
import com.example.work.employee.service.ISectionTypeService;
import com.example.work.employee.service.IStandardTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String goAddForm() {
        return null;
    }
}
