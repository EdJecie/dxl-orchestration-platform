package com.edna.dxl.billing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillingController {

    private final BillingRepository repository;

    public BillingController(BillingRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/billing/charge")
    public String charge(@RequestParam String userId) {
        BillingRecord record = new BillingRecord();
        record.setUserId(userId);
        record.setStatus("SUCCESS");

        repository.save(record);

        return "Billing successful for user " + userId;
    }

    if ("fail".equals(userId)) {
        throw new RuntimeException("Simulated failure");
    }
}