package com.changemoney.service.impl;

import com.changemoney.service.IChangeMoneyService;
@org.springframework.stereotype.Service
public class ChangeMoneService implements IChangeMoneyService {
    @Override
    public Double calculator(double inputMoney, double rate) {
        return inputMoney * rate;
    }
}
