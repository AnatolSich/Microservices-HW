package org.example.client;

import org.example.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("recipient")
public interface RecipientClient {

    @GetMapping("/message")
    List<User> getAllMessages();
}
