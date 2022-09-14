package com.example.work.service;

import com.example.work.dto.DetailContractQuantity;
import com.example.work.model.contract.AttachService;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface IAttachSerService {
    List<AttachService> findAll();
    List<AttachService> showListOfAttach(Integer id);
    List<DetailContractQuantity> showListOfAttachTotal( Integer id);

}
