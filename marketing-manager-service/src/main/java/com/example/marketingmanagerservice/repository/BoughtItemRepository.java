package com.example.marketingmanagerservice.repository;

import com.example.marketingmanagerservice.model.BoughtItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoughtItemRepository extends JpaRepository<BoughtItem, Long> {
}
