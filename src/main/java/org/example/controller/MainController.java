package org.example.controller;

import org.example.model.RequestDto;
import org.example.model.ResponseDto;
import org.example.service.BankService;
import org.example.service.Currency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;

@RestController
public class MainController {

    private final Logger logger = LoggerFactory.getLogger(MainController.class);

    ObjectMapper objectMapper = new ObjectMapper();

    private final BankService bankService;

    @Autowired
    public MainController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping(
            value = "/info/postBalances",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Object postBalances(@RequestBody RequestDto requestDto) {
        try {
            String clientId = requestDto.getClientId();
            String rqUID = requestDto.getRqUID();

            Currency currency = bankService.getCurrency(requestDto.getClientId());
            BigDecimal maxLimit = bankService.getMaxLimit(currency);
            BigDecimal balance = bankService.getRandomBalance(currency);

            ResponseDto responseDto = new ResponseDto(
                    rqUID,
                    clientId,
                    requestDto.getAccount(),
                    currency.getValue(),
                    balance,
                    maxLimit
            );

            logger.error(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestDto));
            logger.error(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(responseDto));

            return responseDto;
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
