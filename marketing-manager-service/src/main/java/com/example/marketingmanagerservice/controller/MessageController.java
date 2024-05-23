package com.example.marketingmanagerservice.controller;

import com.example.marketingmanagerservice.model.Message;
import com.example.marketingmanagerservice.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marketingmanager/messages")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @GetMapping("/{id}")
    public Message getArticleById(@PathVariable long id) {
        return messageRepository.findById((int) id).orElse(null);
    }

    @PostMapping
    public Message createMessage(@RequestBody Message message) {
        return messageRepository.save(message);
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable long id) {
        messageRepository.deleteById((int) id);
    }
}
