package com.example.marketingmanagerservice.service;

import com.example.marketingmanagerservice.dto.CartItemDTO;
import com.example.marketingmanagerservice.model.ArticleWarehouse;
import com.example.marketingmanagerservice.repository.ArticleWarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleWarehouseService {

    @Autowired
    private ArticleWarehouseRepository articleWarehouseRepository;

    public void buyItems(List<CartItemDTO> cartItems) throws Exception {
        for (CartItemDTO item : cartItems) {
            List<ArticleWarehouse> articleWarehouses = articleWarehouseRepository.findByArticleId(item.getArticleId());
            int quantityNeeded = item.getQuantity();
            for (ArticleWarehouse articleWarehouse : articleWarehouses) {
                if (articleWarehouse.getAmount() >= quantityNeeded) {
                    articleWarehouse.setAmount(articleWarehouse.getAmount() - quantityNeeded);
                    articleWarehouseRepository.save(articleWarehouse);
                    quantityNeeded = 0;
                    break;
                } else {
                    quantityNeeded -= articleWarehouse.getAmount();
                    articleWarehouse.setAmount(0);
                    articleWarehouseRepository.save(articleWarehouse);
                }
            }
            if (quantityNeeded > 0) {
                throw new Exception("Not enough articles available in the warehouses.");
            }
        }
    }
}
