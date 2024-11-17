package com.hiroyalty.kafka.consumer;

import com.hiroyalty.kafka.payload.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@Slf4j
public class KafkaConsumer {

    // @KafkaListener(topics = "hiroyalty", groupId = "myGroup")
    public void consumeMessage(String msg) {
        log.info(format("Consuming message from hiroyalty Topic:: %s", msg));
    }

    @KafkaListener(topics = "hiroyalty", groupId = "myGroup")
    public void consumeJsonMessage(Customer customer) {
        log.info(format("Consuming JSON message from hiroyalty Topic:: %s", customer.toString()));
    }
}
