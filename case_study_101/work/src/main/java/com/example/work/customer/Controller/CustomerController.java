package com.example.work.customer.Controller;

import com.example.work.customer.model.Customer;
import com.example.work.customer.service.ICustomerService;
import com.example.work.customer.service.ICustomerTypeService;
import com.example.work.dto.CustomerDto1;
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
        model.addAttribute("customerList",new CustomerDto1());
        model.addAttribute("type", iCustomerTypeService.findAll());
        return "/customers/customer_adding_page";
    }

    @PostMapping("/saveCustomer")
    public String goSaveCustomer(@ModelAttribute("customerList") @Valid CustomerDto1 customerDto1,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("type", iCustomerTypeService.findAll());
            return "/customers/customer_adding_page";
        }
        Customer customer= new Customer();
        BeanUtils.copyProperties(customerDto1,customer);
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/listCustomer";
    }

    @GetMapping("/getDetele")
    public String goDelete(@RequestParam int deleteId, RedirectAttributes redirectAttributes) {
        iCustomerService.delete(deleteId);
        redirectAttributes.addFlashAttribute("msg", "Xóa thành công");
        return "redirect:/listCustomer";
    }

    @GetMapping("/goUpdate")
    public String goUpdate(Integer id, Model model) {
        model.addAttribute("customer", iCustomerService.findById(id).get());
        model.addAttribute("type", iCustomerTypeService.findAll());
        return "/customers/customer_update_page";
    }

    @PostMapping("/saveUpdate")
    public String saveUpdate(@ModelAttribute("customer") @Valid  CustomerDto1 customerDto,
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
        redirectAttributes.addFlashAttribute("msg", "Sửa thành công");
        return "redirect:/listCustomer";
    }
}
