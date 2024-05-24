package com.example.marketingmanagerservice.dto;

public class CartItemDTO {
    private Long articleId;
    private int quantity;

    // Getters and setters
    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
