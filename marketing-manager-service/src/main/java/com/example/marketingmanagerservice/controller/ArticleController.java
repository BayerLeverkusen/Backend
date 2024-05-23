package com.example.marketingmanagerservice.controller;

import com.example.marketingmanagerservice.model.Article;
    import com.example.marketingmanagerservice.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marketingmanager/articles")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable long id) {
        return articleRepository.findById((int) id).orElse(null);
    }

    @PostMapping
    public Article createArticle(@RequestBody Article article) {
        return articleRepository.save(article);
    }

    @PutMapping("/{id}")
    public Article updateArticle(@PathVariable long id, @RequestBody Article updatedArticle) {
        if (!articleRepository.existsById((int) id)) {
            return null; // Or throw an exception
        }
        updatedArticle.setId(id); // Ensure the ID is set correctly
        return articleRepository.save(updatedArticle);
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable long id) {
        articleRepository.deleteById((int) id);
    }
}
