package com.example.marketingmanagerservice.repository;

import com.example.marketingmanagerservice.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository <Message, Integer> {
}
