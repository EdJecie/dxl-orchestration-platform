package com.edna.dxl.billing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillingController {

    @GetMapping("/billing/charge")
    public String charge(@RequestParam String userId) {
        return "Billing successful for user " + userId;
    }
}
