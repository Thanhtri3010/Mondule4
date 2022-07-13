package com.example.service.impl;

import com.example.service.ICurrencyService;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService implements ICurrencyService {


    @Override
    public double exchange(double usd, double rate) {
        return usd * rate;
    }
}
