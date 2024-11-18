package com.halitesolutions.wikimedia.producer.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@Slf4j
public class WikimediaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg) {
        log.info(format("Sending message to wikimedia-stream Topic:: %s", msg));
        kafkaTemplate.send("wikimedia-stream", msg);
    }
//    private final KafkaTemplate<String, Object> kafkaTemplate;
//
//    public <T> void sendMessage(T payload) {
//        Message<T> message = MessageBuilder
//                .withPayload(payload)
//                .setHeader(KafkaHeaders.TOPIC, "wikimedia-stream")
//                .build();
//
//        kafkaTemplate.send(message);
//    }
}
