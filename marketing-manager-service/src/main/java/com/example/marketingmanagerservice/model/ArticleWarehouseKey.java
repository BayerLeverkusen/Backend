package com.example.marketingmanagerservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ArticleWarehouseKey implements Serializable {

    @Column(name = "article_id")
    private Long articleId;

    @Column(name = "warehouse_id")
    private Long warehouseId;
}
