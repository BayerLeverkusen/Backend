package com.example.marketingmanagerservice.repository;

import com.example.marketingmanagerservice.model.Article;
import com.example.marketingmanagerservice.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {
}
