package org.example;


import com.currency.converter.CurrencyConverter;
import com.currency.converter.CurrencyRates;
import com.currency.converter.Validator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyRates rates = new CurrencyRates();
        CurrencyConverter converter = new CurrencyConverter(rates);

        System.out.println("🌍 Welcome to Currency Converter");

        while (true) {
            System.out.print("\nEnter FROM currency (e.g., USD): ");
            String from = scanner.nextLine().toUpperCase();

            System.out.print("Enter TO currency (e.g., INR): ");
            String to = scanner.nextLine().toUpperCase();

            System.out.print("Enter amount: ");
            String inputAmount = scanner.nextLine();

            if (!Validator.isValidCurrency(from, rates) || !Validator.isValidCurrency(to, rates)) {
                System.out.println("❌ Invalid currency entered.");
                continue;
            }

            if (!Validator.isValidAmount(inputAmount)) {
                System.out.println("❌ Invalid amount entered.");
                continue;
            }

            double amount = Double.parseDouble(inputAmount);
            double result = converter.convert(from, to, amount);

            System.out.printf("✅ %.2f %s = %.2f %s\n", amount, from, result, to);

            System.out.print("Convert again? (yes/no): ");
            String repeat = scanner.nextLine();
            if (!repeat.equalsIgnoreCase("yes")) break;
        }

        System.out.println("Thank you for using the converter!");
        scanner.close();
    }
}
