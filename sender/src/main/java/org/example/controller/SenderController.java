package org.example.controller;

import org.example.config.MessageQueueConfig;
import org.example.model.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class SenderController {

    private final RabbitTemplate template;

    public SenderController(RabbitTemplate template) {
        this.template = template;
    }

    @PostMapping("/notification")
    public String notificaions(@RequestBody User user) {
        template.convertSendAndReceive(MessageQueueConfig.TOPIC_EXCHANGE, MessageQueueConfig.ROUTING_KEY, user);
        log.info("User " + user.getUser() + " added to DB");
        return "SENT";
    }
}
