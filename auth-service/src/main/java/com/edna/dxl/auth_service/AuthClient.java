package com.edna.dxl.dxl.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "auth-service", url = "http://auth-service:8081")
public interface AuthClient {

    @GetMapping("/auth/validate")
    String validate(@RequestHeader("Authorization") String token);
}
