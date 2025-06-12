package com.currency.converter;

import java.util.HashMap;
import java.util.Map;

public class CurrencyRates {
    private final Map<String, Double> rates;

    public CurrencyRates() {
        rates = new HashMap<>();
        rates.put("INR", 1.0);
        rates.put("USD", 0.012);
        rates.put("EUR", 0.011);
        rates.put("GBP", 0.0095);
        rates.put("JPY", 1.64);
    }

    public boolean isSupported(String currency) {
        return rates.containsKey(currency.toUpperCase());
    }

    public double getRate(String currency) {
        return rates.getOrDefault(currency.toUpperCase(), -1.0);
    }
}
