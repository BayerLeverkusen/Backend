package com.example.IdentityService.service;

import com.example.IdentityService.model.Fan;
import com.example.IdentityService.repository.FanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FanService {

    @Autowired
    private FanRepository fanRepository;

    public int getBalanceByUsername(String username) {
        Fan fan = fanRepository.findByUsername(username);
        if (fan != null) {
            return fan.getBalance();
        } else {
            throw new RuntimeException("Fan not found with username: " + username);
        }
    }

    public void addFundsToBalance(String username, int amount) {
        Fan fan = fanRepository.findByUsername(username);
        if (fan != null) {
            int newBalance = fan.getBalance() + amount;
            fan.setBalance(newBalance);
            fanRepository.save(fan);
        }
    }

    public void updateBalance(String username, int newBalance) {
        Fan fan = fanRepository.findByUsername(username);
        if (fan != null) {
            fan.setBalance(newBalance);
            fanRepository.save(fan);
        }
    }


}
