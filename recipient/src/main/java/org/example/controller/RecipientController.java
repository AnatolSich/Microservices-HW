package org.example.controller;

import org.example.model.User;
import org.example.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
public class RecipientController {

    private final UserRepository userRepository;

    public RecipientController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/message")
    public List<User> message() {
        List<User> list = userRepository.findAll();
        userRepository.deleteAll();
        log.info("All users deleted from DB");
        return list;
    }
}
