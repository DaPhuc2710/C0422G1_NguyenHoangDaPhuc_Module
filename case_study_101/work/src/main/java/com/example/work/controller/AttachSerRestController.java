package com.example.work.controller;

import com.example.work.dto.DetailContractQuantity;
import com.example.work.model.contract.AttachService;
import com.example.work.service.IAttachSerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AttachSerRestController {
    @Autowired
    private IAttachSerService iAttachSerService;
    @GetMapping("/attachList")
    public ResponseEntity<List<DetailContractQuantity>> showAttach(Integer id){
//        List<AttachService> attachServiceList= iAttachSerService.showListOfAttach(id);
        List<DetailContractQuantity> listOfAttachTotal= iAttachSerService.showListOfAttachTotal(id);
        if (listOfAttachTotal.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listOfAttachTotal,HttpStatus.OK);
    }
}
