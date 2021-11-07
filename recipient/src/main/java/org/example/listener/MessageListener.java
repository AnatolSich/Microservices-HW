package org.example.listener;


import org.example.config.MessageQueueConfig;
import org.example.model.User;
import org.example.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@Log4j2
public class MessageListener {

    private final UserRepository userRepository;

    public MessageListener(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RabbitListener(queues = MessageQueueConfig.QUEUE_NAME)
    private void rabbitListener(User user) throws InterruptedException {
        userRepository.save(user);
        log.info("User {} saved to DB", user.getUser());
    }
}
