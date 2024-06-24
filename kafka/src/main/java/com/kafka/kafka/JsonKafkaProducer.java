package com.kafka.kafka;

import com.kafka.model.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.messaging.Message;
@Service
public class JsonKafkaProducer {
     private final KafkaTemplate<String, User> kafkaTemplate;

     public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate){
         this.kafkaTemplate = kafkaTemplate;
     }
     public void sendMassage(User user){
         Message<User> massage = MessageBuilder
                 .withPayload(user)
                 .setHeader(KafkaHeaders.TOPIC,"MyTopicJson")
                 .build();
         kafkaTemplate.send(massage);
     }
}
