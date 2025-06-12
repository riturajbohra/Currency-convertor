package com.currency.converter;


public class CurrencyConverter {
    private final CurrencyRates rates;

    public CurrencyConverter(CurrencyRates rates) {
        this.rates = rates;
    }

    public double convert(String from, String to, double amount) {
        double fromRate = rates.getRate(from);
        double toRate = rates.getRate(to);
        return (amount / fromRate) * toRate;
    }
}
