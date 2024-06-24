package com.kafka.controller;

import com.kafka.kafka.JsonKafkaProducer;
import com.kafka.kafka.KafkaProducer;
import com.kafka.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class MassageController {
    @Autowired
    private KafkaProducer kafkaProducer;
    @Autowired
    private JsonKafkaProducer jsonKafkaProducer;


    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("massage") String massage){
         kafkaProducer.sendMassage(massage);
         return ResponseEntity.ok("Massage was sand to the topic");
    }
    @PostMapping("/publishJson")
    public ResponseEntity<String> publish(@RequestBody User user){
        jsonKafkaProducer.sendMassage(user);
        return ResponseEntity.ok(" JSON Massage was sand to the topic");
    }

}
