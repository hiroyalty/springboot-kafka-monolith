package com.hiroyalty.kafka.rest;

import com.hiroyalty.kafka.payload.Customer;
import com.hiroyalty.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {

    private final KafkaProducer kafkaProducer;

    @PostMapping
    public ResponseEntity<String> publishMessage(
            @RequestBody String message
    ) {
        kafkaProducer.publishMessage("hiroyalty", message);
        return ResponseEntity.ok("Message queued successfully!");
    }

    @PostMapping("/json")
    public ResponseEntity<String> publishJsonMessage(
            @RequestBody Customer message
    ) {
        kafkaProducer.publishMessage("hiroyalty", message);
        return ResponseEntity.ok("Message queued successfully as JSON!");
    }
}
