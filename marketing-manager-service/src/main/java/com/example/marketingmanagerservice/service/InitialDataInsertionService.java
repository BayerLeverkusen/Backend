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

        Article article6 = Article.builder()
                .name("Hat")
                .description("Stylish hat with the Bayer Leverkusen logo. Great for sunny days at the stadium.")
                .price(14.99)
                .build();

        Article article7 = Article.builder()
                .name("Keychain")
                .description("Keychain with the Bayer Leverkusen emblem. Carry your team spirit wherever you go.")
                .price(9.99)
                .build();

        Article article8 = Article.builder()
                .name("Mug")
                .description("Coffee mug with the Bayer Leverkusen logo. Enjoy your favorite beverage while supporting your team.")
                .price(12.99)
                .build();

        Article article9 = Article.builder()
                .name("Flag")
                .description("Large flag featuring the Bayer Leverkusen colors and emblem. Show your support loud and proud!")
                .price(24.99)
                .build();

        Article article10 = Article.builder()
                .name("Socks")
                .description("Comfortable socks with the Bayer Leverkusen crest. Keep your feet warm and stylish.")
                .price(7.99)
                .build();

        Article article11 = Article.builder()
                .name("Phone Case")
                .description("Protective phone case with the Bayer Leverkusen emblem. Keep your device safe and show your team pride.")
                .price(17.99)
                .build();

        Article article12 = Article.builder()
                .name("Sticker Pack")
                .description("Assorted sticker pack featuring the Bayer Leverkusen logo and players. Customize your belongings with team spirit.")
                .price(8.99)
                .build();

        Article article13 = Article.builder()
                .name("Mouse Pad")
                .description("Mouse pad with the Bayer Leverkusen colors and crest. Enhance your workspace with team pride.")
                .price(11.99)
                .build();

        Article article14 = Article.builder()
                .name("Water Bottle")
                .description("Reusable water bottle with the Bayer Leverkusen logo. Stay hydrated while supporting your team.")
                .price(15.99)
                .build();

        Article article15 = Article.builder()
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
        articleRepository.save(article6);
        articleRepository.save(article7);
        articleRepository.save(article8);
        articleRepository.save(article9);
        articleRepository.save(article10);
        articleRepository.save(article11);
        articleRepository.save(article12);
        articleRepository.save(article13);
        articleRepository.save(article14);
        articleRepository.save(article15);
    }
}
