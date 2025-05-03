package org.example.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class BankServiceImpl implements BankService {

    @Override
    public Currency getCurrency(String number) {
        char firstDigit = number.charAt(0);
        Currency currency;
        switch (firstDigit) {
            case '8' -> currency = Currency.US;
            case '9' -> currency = Currency.EU;
            default -> currency = Currency.RUB;
        }
        return currency;
    }

    @Override
    public BigDecimal getMaxLimit(Currency currency) {
        return switch (currency) {
            case US -> BigDecimal.valueOf(2000);
            case EU -> BigDecimal.valueOf(1000);
            default -> BigDecimal.valueOf(10000);
        };
    }

    @Override
    public BigDecimal getRandomBalance(Currency currency) {
        BigDecimal max = getMaxLimit(currency);
        BigDecimal randomDec = BigDecimal.valueOf(Math.random());
        BigDecimal balance = randomDec.multiply(max);
        balance = balance.setScale(2, RoundingMode.DOWN);
        return balance;
    }
}
