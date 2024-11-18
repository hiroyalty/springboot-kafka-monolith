package com.hiroyalty.kafka.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hiroyalty.kafka.payload.Customer;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@Slf4j
public class KafkaConsumer {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "hiroyalty", groupId = "myGroup")
    public void consumeMessage(ConsumerRecord<String, Object> record) {
        Object message = record.value();
        if (message instanceof String) {
            log.info(format("Consuming message from hiroyalty Topic:: %s", message));
        } else {
            try {
                Customer customer = objectMapper.convertValue(message, Customer.class);
                log.info(format("Consuming JSON message from hiroyalty Topic:: %s", customer.toString()));
            } catch (Exception e) {
                log.error("Failed to process message: {}", message, e);
            }
        }
    }
}
