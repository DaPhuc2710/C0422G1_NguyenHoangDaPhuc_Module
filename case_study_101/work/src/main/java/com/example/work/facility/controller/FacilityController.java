package com.example.work.facility.controller;

import com.example.work.dto.FacilityDto;
import com.example.work.facility.model.Facility;
import com.example.work.facility.service.IFacilityRentTypeService;
import com.example.work.facility.service.IFacilityService;
import com.example.work.facility.service.ITypeOfSerService;
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
public class FacilityController {
    @Autowired
    IFacilityRentTypeService iFacilityRentTypeService;
    @Autowired
    IFacilityService iFacilityService;
    @Autowired
    ITypeOfSerService iTypeOfSerService;

    @GetMapping("/listFacility")
    public String goList(Model model,
                         @PageableDefault(size = 5) Pageable pageable,
                         @RequestParam Optional<String> key) {
        String keyVal = key.orElse("");
        model.addAttribute("facilityList", iFacilityService.findAllByFacNameCustomerContaining(keyVal, pageable));
        model.addAttribute("keyVal", keyVal);
        return "/services/services_list_page";
    }

    @GetMapping("/goDelete")
    public String goDetele(@RequestParam Integer deleteId, RedirectAttributes redirectAttributes) {
        iFacilityService.delete(deleteId);
        redirectAttributes.addFlashAttribute("msg", "Xóa thành công");
        return "redirect:/listFacility";
    }

    @GetMapping("/addFacility")
    public String goAddForm(Model model) {
        model.addAttribute("services", new FacilityDto());
        model.addAttribute("facilityRentType", iFacilityRentTypeService.findAll());
        model.addAttribute("typeOfSerService", iTypeOfSerService.findAll());
        return "/services/services_adding_page";
    }

    @PostMapping("/saveFacilityForm")
    public String goSaveFacilityForm(@ModelAttribute("services") @Valid FacilityDto facilityDto,
                                     BindingResult bindingResult,
                                     RedirectAttributes redirectAttributes,
                                     Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("facilityRentType", iFacilityRentTypeService.findAll());
            model.addAttribute("typeOfSerService", iTypeOfSerService.findAll());
            return "/services/services_adding_page";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        iFacilityService.save(facility);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công ");
        return "redirect:/listFacility";
    }

    @GetMapping("/goUpdateList")
    public String goUpdateForm(Model model, Integer id) {
        model.addAttribute("services", iFacilityService.findById(id).get());
        model.addAttribute("facilityRentType", iFacilityRentTypeService.findAll());
        model.addAttribute("typeOfSerService", iTypeOfSerService.findAll());
        return "/services/services_update_page";
    }

    @PostMapping("/saveUpdateForm")
    public String goUpdateForm(@ModelAttribute("services") @Valid FacilityDto facilityDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("facilityRentType", iFacilityRentTypeService.findAll());
            model.addAttribute("typeOfSerService", iTypeOfSerService.findAll());
            return "/services/services_update_page";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        iFacilityService.update(facility);
        redirectAttributes.addFlashAttribute("msg", "Chỉnh sửa thành công ");
        return "redirect:/listFacility";
    }
}
