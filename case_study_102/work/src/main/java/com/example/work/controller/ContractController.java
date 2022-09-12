package com.example.work.controller;

import com.example.work.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
@Controller
public class ContractController {
    @Autowired
    private IContractService iContractService;

    @GetMapping("/goContractList")
    public String goContractList(Model model, @RequestParam Optional<String> key,
                                 @PageableDefault(size = 5) Pageable pageable) {
        String keyVal = key.orElse("");
        model.addAttribute("contractList", iContractService.findAllByCustomerContaining(keyVal, pageable));
        model.addAttribute("keyVal", keyVal);
        return "/contracts/contract_list";
    }

//    @GetMapping("/goAddContract")
//    public String goAddForm(Model model) {
//        model.addAttribute("", new Contract());
//        return null;
//    }
}
