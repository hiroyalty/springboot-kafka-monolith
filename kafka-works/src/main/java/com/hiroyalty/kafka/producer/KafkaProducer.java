package com.hiroyalty.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j // annotation to add a logger to our methods
public class KafkaProducer {

    //private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public <T> void publishMessage(String topic, T payload) {
        Message<T> message = MessageBuilder
                .withPayload(payload)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();

        kafkaTemplate.send(message);
    }
//    public void publishMessage(String msg) {
//        log.info(String.format("Sending message to hiroyalty topic:: %s", msg));
//        kafkaTemplate.send("hiroyalty", msg);
//    }
}
