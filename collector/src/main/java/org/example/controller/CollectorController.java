package org.example.controller;


import org.example.client.RecipientClient;
import org.example.model.User;
import org.example.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
public class CollectorController {


    private final RecipientClient recipientClient;
    private final UserRepository userRepository;

    public CollectorController(RecipientClient recipientClient, UserRepository userRepository) {
        this.recipientClient = recipientClient;
        this.userRepository = userRepository;
    }

    @GetMapping

    @Scheduled(fixedRate = 15_000, initialDelay = 3_000)
    public List<User> getRecipientMessages() {
        List<User> users = recipientClient.getAllMessages();
        if (users.size() == 0) {
            log.info("No messages to save");
        } else {
            users.forEach(user -> {
                userRepository.save(user);
                log.info("User {} was saved to DB", user.getUser());
            });
        }
        return users;
    }
}
