package com.edna.dxl.dxl.controller;

import com.edna.dxl.dxl.client.AuthClient;
import com.edna.dxl.dxl.client.BillingClient;
import org.springframework.web.bind.annotation.*;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@CircuitBreaker(name = "billingService", fallbackMethod = "billingFallback")
@RestController
@RequestMapping("/dxl")
public class DxlController {

    private final AuthClient authClient;
    private final BillingClient billingClient;

    private static final Logger log = LoggerFactory.getLogger(DxlController.class);

    public DxlController(AuthClient authClient, BillingClient billingClient) {
        this.authClient = authClient;
        this.billingClient = billingClient;
    }

    @PostMapping("/process")
    public String process(
            @RequestHeader("Authorization") String token,
            log.info("DXL request received for user {}", userId);
            @RequestParam String userId


    ) {
        String authResult = authClient.validate(token);

        if (!"VALID_TOKEN".equals(authResult)) {
            return "Authentication failed";
        }

        return billingClient.charge(userId);
    }

    public String billingFallback(String token, String userId, Throwable ex) {
        return "Billing service currently unavailable. Please try again later.";
    }
}
