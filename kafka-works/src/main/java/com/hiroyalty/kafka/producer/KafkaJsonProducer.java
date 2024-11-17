package com.hiroyalty.kafka.producer;

import com.hiroyalty.kafka.payload.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaJsonProducer {

    private final KafkaTemplate<String, Customer> kafkaTemplate;

    public void publishMessage(Customer customer) {

        Message<Customer> message = MessageBuilder
                .withPayload(customer)
                .setHeader(KafkaHeaders.TOPIC, "hiroyalty")
                .build();

        kafkaTemplate.send(message);
    }
}
