package com.changemoney.service.impl;

import com.changemoney.service.IService;
@org.springframework.stereotype.Service
public class Service implements IService {
    @Override
    public Double calculator(double inputMoney, double rate) {
        return inputMoney * rate;
    }
}
