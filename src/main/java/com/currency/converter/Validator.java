package com.currency.converter;
public class Validator {
    public static boolean isValidCurrency(String currency, CurrencyRates rates) {
        return rates.isSupported(currency);
    }

    public static boolean isValidAmount(String input) {
        try {
            double val = Double.parseDouble(input);
            return val >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
