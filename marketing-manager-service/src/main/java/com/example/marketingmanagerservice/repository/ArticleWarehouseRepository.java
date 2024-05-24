package com.example.marketingmanagerservice.repository;

import com.example.marketingmanagerservice.model.ArticleWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleWarehouseRepository extends JpaRepository<ArticleWarehouse, Long> {
    List<ArticleWarehouse> findByArticleId(Long articleId);

}
