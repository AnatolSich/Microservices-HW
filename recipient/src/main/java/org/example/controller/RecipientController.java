package org.example.controller;

import org.example.domain.User;
import org.example.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
public class RecipientController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/message")
    public List<User> message() {
        List<User> list = userRepository.findAll();
        userRepository.deleteAll();
        log.info("All users deleted from DB");
        return list;
    }
}
