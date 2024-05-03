package com.example.marketingmanagerservice.service;

import com.example.marketingmanagerservice.model.Article;
import com.example.marketingmanagerservice.repository.ArticleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitialDataInsertionService {

    @Autowired
    private ArticleRepository articleRepository;

    @Transactional
    public void insertInitialData() {
        // Create 5 Article entities with sample data
        Article article1 = Article.builder()
                .name("Official Home Jersey")
                .description("Replica of the official home jersey worn by Bayer Leverkusen players on match days. Made with breathable fabric for comfort and featuring the club's crest.")
                .price(59.99)
                .build();

        Article article2 = Article.builder()
                .name("Scarf")
                .description("Warm scarf featuring the Bayer Leverkusen colors and crest. Perfect for showing your support during cold match days.")
                .price(19.99)
                .build();

        Article article3 = Article.builder()
                .name("Soccer Ball")
                .description("Official Bayer Leverkusen soccer ball, designed for optimal performance on the field. Featuring the club's colors and logo.")
                .price(29.99)
                .build();

        Article article4 = Article.builder()
                .name("Cap")
                .description("Stylish cap featuring the Bayer Leverkusen logo. Adjustable strap for a comfortable fit. Perfect for sunny match days.")
                .price(14.99)
                .build();

        Article article5 = Article.builder()
                .name("Pennant")
                .description("Collectible pennant featuring the Bayer Leverkusen crest. Ideal for decorating your room or office to show your support for the club.")
                .price(9.99)
                .build();

        // Save the Article entities to the database
        articleRepository.save(article1);
        articleRepository.save(article2);
        articleRepository.save(article3);
        articleRepository.save(article4);
        articleRepository.save(article5);
    }
}
