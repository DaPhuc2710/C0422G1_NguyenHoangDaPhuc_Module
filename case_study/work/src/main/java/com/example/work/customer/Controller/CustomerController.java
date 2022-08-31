package com.example.work.customer.Controller;

import com.example.work.customer.model.Customer;
import com.example.work.customer.service.ICustomerService;
import com.example.work.customer.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("/listCustomer")
    public String goListCustomer(Model model,
                                 @PageableDefault(size = 5) Pageable pageable,
                                 @RequestParam Optional<String> key) {
        String keyVal = key.orElse("");
        model.addAttribute("customerList", iCustomerService.findAllByNameCustomerContaining(keyVal, pageable));
        model.addAttribute("keyVal", keyVal);
        return "/customers/customer_list_page";
    }

    @GetMapping("/addCustomer")
    public String goAddCustomer(Model model) {
        model.addAttribute("customerList", new Customer());
        model.addAttribute("type", iCustomerTypeService.findAll());
        return "/customers/customer_adding_page";
    }

    @PostMapping("/saveCustomer")
    public String goSaveCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/listCustomer";
    }

    @GetMapping("/getDetele")
    public String goDelete(@RequestParam int deleteId) {
        iCustomerService.delete(deleteId);
        return "redirect:/listCustomer";

    }

    @GetMapping("/goUpdate")
    public String goUpdate(int id, Model model) {
        model.addAttribute("customer", iCustomerService.findById(id).get());
        model.addAttribute("type", iCustomerTypeService.findAll());
        return "/customers/customer_update_page";
    }

    @PostMapping("/saveUpdate")
    public String saveUpdate(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        iCustomerService.update(customer);
        redirectAttributes.addFlashAttribute("msg", "Sửa thành công");
        return "redirect:/listCustomer";
    }
}
