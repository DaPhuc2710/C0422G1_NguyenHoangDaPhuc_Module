package com.example.work.contract.controller;

import com.example.work.contract.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//  Model model,
//@RequestParam Optional<String> key,
//@PageableDefault(size = 5) Pageable pageable) {
//        String keyVal = key.orElse("");
//        model.addAttribute("contractList", iContractService.findAllByCustomerContainingAndEmployeeContaining(keyVal, pageable));
//        model.addAttribute("keyVal", keyVal);
@Controller
public class ContractController {
    @Autowired
    private IContractService iContractService;

    @GetMapping("/goContractList")
    public String goContractList(Model model) {
        model.addAttribute("contractList", iContractService.findAll());
        return "/contracts/contract_list";
    }
}
