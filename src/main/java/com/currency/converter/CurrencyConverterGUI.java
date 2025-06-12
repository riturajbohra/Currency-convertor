package com.currency.converter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverterGUI extends JFrame {
    private JComboBox<String> fromCurrency;
    private JComboBox<String> toCurrency;
    private JTextField amountField;
    private JLabel resultLabel;

    private final Map<String, Double> rates = new HashMap<>();

    public CurrencyConverterGUI() {
        setTitle("Currency Converter");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 10, 10));

        initializeRates();

        JLabel fromLabel = new JLabel("From:");
        fromCurrency = new JComboBox<>(rates.keySet().toArray(new String[0]));

        JLabel toLabel = new JLabel("To:");
        toCurrency = new JComboBox<>(rates.keySet().toArray(new String[0]));

        JLabel amountLabel = new JLabel("Amount:");
        amountField = new JTextField();

        JButton convertButton = new JButton("Convert");
        resultLabel = new JLabel("Result: ");

        add(fromLabel);
        add(fromCurrency);
        add(toLabel);
        add(toCurrency);
        add(amountLabel);
        add(amountField);
        add(new JLabel(""));
        add(convertButton);
        add(new JLabel(""));
        add(resultLabel);

        convertButton.addActionListener(e -> convertCurrency());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeRates() {
        rates.put("INR", 1.0);
        rates.put("USD", 0.012);
        rates.put("EUR", 0.011);
        rates.put("GBP", 0.0095);
        rates.put("JPY", 1.64);
    }

    private void convertCurrency() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            String from = (String) fromCurrency.getSelectedItem();
            String to = (String) toCurrency.getSelectedItem();

            double converted = (amount / rates.get(from)) * rates.get(to);
            resultLabel.setText(String.format("Result: %.2f %s", converted, to));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid amount. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new CurrencyConverterGUI();
    }
}
