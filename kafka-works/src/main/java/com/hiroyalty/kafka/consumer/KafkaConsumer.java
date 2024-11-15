package com.hiroyalty.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "hiroyalty", groupId = "myGroup")
    public void consumeMessage(String msg) {
        log.info(String.format("Consuming message from hiroyalty Topic:: %s", msg));
    }
}
