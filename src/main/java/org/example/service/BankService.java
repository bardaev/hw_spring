package org.example.service;

import java.math.BigDecimal;

public interface BankService {

    public Currency getCurrency(String number);
    public BigDecimal getMaxLimit(Currency currency);
    public BigDecimal getRandomBalance(Currency currency);
}
