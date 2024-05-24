package com.example.marketingmanagerservice.controller;

import com.example.marketingmanagerservice.dto.CartItemDTO;
import com.example.marketingmanagerservice.service.ArticleWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marketingmanager/articlewarehouse")
public class ArticleWarehouseController {

    @Autowired
    private ArticleWarehouseService articleWarehouseService;

    @PostMapping("/buy")
    public ResponseEntity<Void> buyItems(@RequestBody List<CartItemDTO> cartItems) {
        try {
            System.out.println("Received request to buy items: " + cartItems);
            articleWarehouseService.buyItems(cartItems);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            System.err.println("Error purchasing items: " + e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
