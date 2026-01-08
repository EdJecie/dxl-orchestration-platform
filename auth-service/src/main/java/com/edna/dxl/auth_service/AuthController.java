package com.edna.dxl.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("/auth/validate")
    public String validateToken(
            @RequestHeader("Authorization") String token
    ) {
        if (token == null || !token.startsWith("Bearer ")) {
            return "INVALID_TOKEN";
        }
        return "VALID_TOKEN";
    }
}
