package com.example.work.controller;

import com.example.work.model.customer.Customer;
import com.example.work.dto.CustomerDto;
import com.example.work.service.ICustomerService;
import com.example.work.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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
        model.addAttribute("customerList",new CustomerDto());
        model.addAttribute("type", iCustomerTypeService.findAll());
        return "/customers/customer_adding_page";
    }

    @PostMapping("/saveCustomer")
    public String goSaveCustomer(@ModelAttribute("customerList") @Valid CustomerDto customerDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {
        customerDto.validate(customerDto,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("type", iCustomerTypeService.findAll());
            return "/customers/customer_adding_page";
        }
        Customer customer= new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("msg", "Th??m m???i th??nh c??ng");
        return "redirect:/listCustomer";
    }

    @GetMapping("/getDetele")
    public String goDelete(@RequestParam int deleteId, RedirectAttributes redirectAttributes) {
        iCustomerService.delete(deleteId);
        redirectAttributes.addFlashAttribute("msg", "X??a th??nh c??ng");
        return "redirect:/listCustomer";
    }

    @GetMapping("/goUpdate")
    public String goUpdate(Integer id, Model model) {
        model.addAttribute("customer", iCustomerService.findById(id).get());
        model.addAttribute("type", iCustomerTypeService.findAll());
        return "/customers/customer_update_page";
    }

    @PostMapping("/saveUpdate")
    public String saveUpdate(@ModelAttribute("customer") @Valid CustomerDto customerDto,
                             BindingResult bindingResult ,
                             RedirectAttributes redirectAttributes, Model model) {
        customerDto.validate(customerDto,bindingResult);

        if (bindingResult.hasErrors()){
            model.addAttribute("type", iCustomerTypeService.findAll());
            return "/customers/customer_update_page";
        }
        Customer customer= new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        iCustomerService.update(customer);
        redirectAttributes.addFlashAttribute("msg", "S???a th??nh c??ng");
        return "redirect:/listCustomer";
    }
}
