package com.kafka.kafka;

import com.kafka.exceptions.ApiException;
import com.kafka.model.User;
import com.kafka.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
    @Autowired
    private UserRepository userRepository;

    @KafkaListener(topics = "MyTopicJson", groupId = "myGroup")
    public void consume(User user) {
        try {
            userRepository.save(user);
        } catch (Exception ex) {
            throw new ApiException("Problem during saving message");
        }

    }

}
