package com.micros.fraud.controller;

import com.micros.fraud.model.FraudCheckResponse;
import com.micros.fraud.service.FraudCheckService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
public class FraudCheckController {

    private final FraudCheckService fraudCheckService;

    public FraudCheckController(FraudCheckService fraudCheckService) {
        this.fraudCheckService = fraudCheckService;
    }

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable Integer customerId) {
       return new FraudCheckResponse(fraudCheckService.isFraudulentCustomer(customerId));
    }
}
