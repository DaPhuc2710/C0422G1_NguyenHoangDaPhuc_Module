package com.example.phone_management.controller;

import com.example.phone_management.model.SmartPhone;
import com.example.phone_management.service.ISmartPhoneService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/smart")
public class SmartRestController {
    @Autowired
    private ISmartPhoneService iSmartPhoneService;

    @GetMapping("/list")
    public ResponseEntity<List<SmartPhone>> goSmartphoneList() {
        List<SmartPhone> page = iSmartPhoneService.findAll();

        if (page.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @GetMapping("/showUpdate")
    public ResponseEntity<SmartPhone> showUpdate (@RequestParam Long id) {
        SmartPhone smartphone = iSmartPhoneService.findById(id);
        return new ResponseEntity<>(smartphone,HttpStatus.OK);
    }
    @PostMapping ("/saveUpdate")
    public ResponseEntity<Void> saveUpdate (@RequestBody SmartPhone smartphone) {
        iSmartPhoneService.save(smartphone);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
