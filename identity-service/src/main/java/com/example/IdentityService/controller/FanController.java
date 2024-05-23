package com.example.IdentityService.controller;

import com.example.IdentityService.service.FanService;
import com.example.IdentityService.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fan")
public class FanController {

    @Autowired
    private FanService fanService;

    @GetMapping("/balance")
    public ResponseEntity<Integer> getBalanceByUsername(Authentication authentication) {
        String username = authentication.getName();
        System.out.println("Username: " + username);

        int balance = fanService.getBalanceByUsername(username);
        return ResponseEntity.ok(balance);
    }

    @PostMapping("/balance/add")
    public ResponseEntity<Void> addFundsToBalance(Authentication authentication, @RequestBody AddFundsRequest addFundsRequest) {
        String username = authentication.getName();
        int amount = addFundsRequest.getAmount();

        fanService.addFundsToBalance(username, amount);
        return ResponseEntity.ok().build();
    }

    public static class AddFundsRequest {
        private int amount;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }
    }
}
