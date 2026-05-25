package org.example.demo_bt1.service;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Override
    public double convert(double usd, double rate) {

        return usd * rate;

    }
}
