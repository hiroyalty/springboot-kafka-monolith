package com.hiroyalty.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j // annotation to add a logger to our methods
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void publishMessage(String msg) {
        log.info(String.format("Sending message to hiroyalty topic:: %s", msg));
        kafkaTemplate.send("hiroyalty", msg);
    }
}
