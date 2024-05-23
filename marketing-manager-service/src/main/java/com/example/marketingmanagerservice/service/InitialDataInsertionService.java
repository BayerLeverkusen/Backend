package com.example.marketingmanagerservice.service;

import java.util.List;
import java.util.ArrayList;
import com.example.marketingmanagerservice.model.Article;
import com.example.marketingmanagerservice.model.Message;
import com.example.marketingmanagerservice.model.Warehouse;
import com.example.marketingmanagerservice.model.ArticleWarehouseKey;
import com.example.marketingmanagerservice.model.ArticleWarehouse;
import com.example.marketingmanagerservice.repository.ArticleRepository;
import com.example.marketingmanagerservice.repository.ArticleWarehouseRepository;
import com.example.marketingmanagerservice.repository.MessageRepository;
import com.example.marketingmanagerservice.repository.WarehouseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitialDataInsertionService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private ArticleWarehouseRepository articleWarehouseRepository;

    @Transactional
    public void insertInitialData() {
        // Create 5 Article entities with sample data
        Article article1 = Article.builder()
                .name("Official Home Jersey")
                .description("Replica of the official home jersey worn by Bayer Leverkusen players on match days. Made with breathable fabric for comfort and featuring the club's crest.")
                .price(59.99)
                .imageUrl("https://www.sportsdirect.com/images/imgzoom/37/37749108_xxl.jpg")
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

        // Messages
        Message message1 = Message.builder()
                .title("Welcome to the Club")
                .body("Thank you for joining the Bayer Leverkusen fan club! Stay tuned for updates.")
                .build();

        Message message2 = Message.builder()
                .title("Match Day Reminder")
                .body("Don't forget to watch the game this Saturday! Let's cheer for a victory!")
                .build();

        Message message3 = Message.builder()
                .title("New Merchandise Available")
                .body("Check out our new merchandise in the store. Show your support with the latest gear!")
                .build();

        Message message4 = Message.builder()
                .title("Fan Meet-Up")
                .body("Join us for a fan meet-up next month. Meet other fans and share your passion for the team!")
                .build();

        Message message5 = Message.builder()
                .title("Exclusive Content")
                .body("Access exclusive content available only to members. Log in to the fan portal for more details.")
                .build();

        Message message6 = Message.builder()
                .title("Season Highlights")
                .body("Relive the best moments of the season with our highlight reel. Watch it now!")
                .build();

        Message message7 = Message.builder()
                .title("Player Interviews")
                .body("Get insights from your favorite players in our exclusive interviews. Available now!")
                .build();

        Message message8 = Message.builder()
                .title("Match Analysis")
                .body("Read the latest match analysis and get expert opinions on the game.")
                .build();

        Message message9 = Message.builder()
                .title("Training Updates")
                .body("Stay updated with the latest training sessions and team preparations.")
                .build();

        Message message10 = Message.builder()
                .title("Thank You Fans")
                .body("We appreciate your continuous support. Let's keep cheering for the team together!")
                .build();

        Warehouse warehouse1 = Warehouse.builder()
                .name("Birmingham 1")
                .build();


        Warehouse warehouse2 = Warehouse.builder()
                .name("Birmingham 2")
                .build();

        Warehouse warehouse3 = Warehouse.builder()
                .name("Birmingham 3")
                .build();



        // Save warehouses
        warehouseRepository.save(warehouse1);
        warehouseRepository.save(warehouse2);
        warehouseRepository.save(warehouse3);

        // Save messages to the database
        messageRepository.save(message1);
        messageRepository.save(message2);
        messageRepository.save(message3);
        messageRepository.save(message4);
        messageRepository.save(message5);
        messageRepository.save(message6);
        messageRepository.save(message7);
        messageRepository.save(message8);
        messageRepository.save(message9);
        messageRepository.save(message10);

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

        // Populate ArticleWarehouse table
        List<Article> articles = articleRepository.findAll();
        List<Warehouse> warehouses = warehouseRepository.findAll();

        // Save warehouses
        warehouseRepository.saveAll(warehouses);

        // Assign articles to warehouses with a random amount (for demonstration)
        List<ArticleWarehouse> articleWarehouses = new ArrayList<>();
        for (Article article : articles) {
            for (Warehouse warehouse : warehouses) {
                int amount = (int) (Math.random() * 10) + 1; // Random amount between 1 and 10
                ArticleWarehouseKey key = new ArticleWarehouseKey(article.getId(), warehouse.getId());
                ArticleWarehouse articleWarehouse = new ArticleWarehouse(key, article, warehouse, amount);
                articleWarehouses.add(articleWarehouse);
            }
        }

        // Save all article warehouses
        articleWarehouseRepository.saveAll(articleWarehouses);
    }
}
