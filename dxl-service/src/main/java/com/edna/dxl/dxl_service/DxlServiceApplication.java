package com.edna.dxl.dxl_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@EnableFeignClients
@RestController
@RequestMapping("/dxl")
public class DxlServiceApplication {

    private final AuthClient authClient;
    private final BillingClient billingClient;

    public DxlServiceApplication(AuthClient authClient,
                                 BillingClient billingClient) {
        this.authClient = authClient;
        this.billingClient = billingClient;
    }

	public static void main(String[] args) {
		SpringApplication.run(DxlServiceApplication.class, args);
	}

    @PostMapping("/process")
    public String process(@RequestHeader("Authorization") String token) {
        authClient.validate(token);
        billingClient.charge();
        return "DXL_PROCESS_SUCCESS";
    }
    @org.springframework.cloud.openfeign.FeignClient(
            name = "auth-service",
            url = "http://auth-service:8081"
    )
    interface AuthClient {
        @PostMapping("/auth/validate")
        String validate(@RequestHeader("Authorization") String token);
    }

    @org.springframework.cloud.openfeign.FeignClient(
            name = "billing-service",
            url = "http://billing-service:8082"
    )
    interface BillingClient {
        @PostMapping("/billing/charge")
        String charge();
    }

}
